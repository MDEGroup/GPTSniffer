

public class PersistentCookieStore implements CookieStore {
    private static final String TAG = PersistentCookieStore.class
            .getSimpleName();

    
    private static final String SP_COOKIE_STORE = "cookieStore";
    private static final String SP_KEY_DELIMITER = "|"; 
    private static final String SP_KEY_DELIMITER_REGEX = "\\"
            + SP_KEY_DELIMITER;
    private SharedPreferences sharedPreferences;

    
    private Map<URI, Set<HttpCookie>> allCookies;

    public PersistentCookieStore(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_COOKIE_STORE,
                Context.MODE_PRIVATE);
        loadAllFromPersistence();
    }

    private void loadAllFromPersistence() {
        allCookies = new HashMap<URI, Set<HttpCookie>>();

        Map<String, ?> allPairs = sharedPreferences.getAll();
        for (Entry<String, ?> entry : allPairs.entrySet()) {
            String[] uriAndName = entry.getKey().split(SP_KEY_DELIMITER_REGEX,
                    2);
            try {
                URI uri = new URI(uriAndName[0]);
                String encodedCookie = (String) entry.getValue();
                HttpCookie cookie = new SerializableHttpCookie()
                        .decode(encodedCookie);

                Set<HttpCookie> targetCookies = allCookies.get(uri);
                if (targetCookies == null) {
                    targetCookies = new HashSet<HttpCookie>();
                    allCookies.put(uri, targetCookies);
                }
                
                
                targetCookies.add(cookie);
            } catch (URISyntaxException e) {
                Log.w(TAG, e);
            }
        }
    }

    @Override
    public synchronized void add(URI uri, HttpCookie cookie) {
        uri = cookieUri(uri, cookie);

        Set<HttpCookie> targetCookies = allCookies.get(uri);
        if (targetCookies == null) {
            targetCookies = new HashSet<HttpCookie>();
            allCookies.put(uri, targetCookies);
        }
        targetCookies.remove(cookie);
        targetCookies.add(cookie);

        saveToPersistence(uri, cookie);
    }

    
    private static URI cookieUri(URI uri, HttpCookie cookie) {
        URI cookieUri = uri;
        if (cookie.getDomain() != null) {
            
            String domain = cookie.getDomain();
            if (domain.charAt(0) == '.') {
                domain = domain.substring(1);
            }
            try {
                cookieUri = new URI(uri.getScheme() == null ? "http"
                        : uri.getScheme(), domain,
                        cookie.getPath() == null ? "/" : cookie.getPath(), null);
            } catch (URISyntaxException e) {
                Log.w(TAG, e);
            }
        }
        return cookieUri;
    }

    private void saveToPersistence(URI uri, HttpCookie cookie) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(uri.toString() + SP_KEY_DELIMITER + cookie.getName(),
                new SerializableHttpCookie().encode(cookie));

        editor.apply();
    }

    @Override
    public synchronized List<HttpCookie> get(URI uri) {
        return getValidCookies(uri);
    }

    @Override
    public synchronized List<HttpCookie> getCookies() {
        List<HttpCookie> allValidCookies = new ArrayList<HttpCookie>();
        for (URI storedUri : allCookies.keySet()) {
            allValidCookies.addAll(getValidCookies(storedUri));
        }

        return allValidCookies;
    }

    private List<HttpCookie> getValidCookies(URI uri) {
        List<HttpCookie> targetCookies = new ArrayList<HttpCookie>();
        
        
        for (URI storedUri : allCookies.keySet()) {
            
            if (checkDomainsMatch(storedUri.getHost(), uri.getHost())) {
                
                if (checkPathsMatch(storedUri.getPath(), uri.getPath())) {
                    targetCookies.addAll(allCookies.get(storedUri));
                }
            }
        }

        
        if (!targetCookies.isEmpty()) {
            List<HttpCookie> cookiesToRemoveFromPersistence = new ArrayList<HttpCookie>();
            for (Iterator<HttpCookie> it = targetCookies.iterator(); it
                    .hasNext(); ) {
                HttpCookie currentCookie = it.next();
                if (currentCookie.hasExpired()) {
                    cookiesToRemoveFromPersistence.add(currentCookie);
                    it.remove();
                }
            }

            if (!cookiesToRemoveFromPersistence.isEmpty()) {
                removeFromPersistence(uri, cookiesToRemoveFromPersistence);
            }
        }
        return targetCookies;
    }

   

    private boolean checkDomainsMatch(String cookieHost, String requestHost) {
        return requestHost.equals(cookieHost) || requestHost.endsWith("." + cookieHost);
    }

    

    private boolean checkPathsMatch(String cookiePath, String requestPath) {
        return requestPath.equals(cookiePath) ||
                (requestPath.startsWith(cookiePath) && cookiePath.charAt(cookiePath.length() - 1) == '/') ||
                (requestPath.startsWith(cookiePath) && requestPath.substring(cookiePath.length()).charAt(0) == '/');
    }

    private void removeFromPersistence(URI uri, List<HttpCookie> cookiesToRemove) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (HttpCookie cookieToRemove : cookiesToRemove) {
            editor.remove(uri.toString() + SP_KEY_DELIMITER
                    + cookieToRemove.getName());
        }
        editor.apply();
    }

    @Override
    public synchronized List<URI> getURIs() {
        return new ArrayList<URI>(allCookies.keySet());
    }

    @Override
    public synchronized boolean remove(URI uri, HttpCookie cookie) {
        Set<HttpCookie> targetCookies = allCookies.get(uri);
        boolean cookieRemoved = targetCookies != null && targetCookies
                .remove(cookie);
        if (cookieRemoved) {
            removeFromPersistence(uri, cookie);
        }
        return cookieRemoved;

    }

    private void removeFromPersistence(URI uri, HttpCookie cookieToRemove) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(uri.toString() + SP_KEY_DELIMITER
                + cookieToRemove.getName());
        editor.apply();
    }

    @Override
    public synchronized boolean removeAll() {
        allCookies.clear();
        removeAllFromPersistence();
        return true;
    }

    private void removeAllFromPersistence() {
        sharedPreferences.edit().clear().apply();
    }

}