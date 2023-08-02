public class ApiAuthenticator implements OkAuthenticator {

  AccountManager accountManager;
  Application application;

  @Inject
  public ApiAuthenticator(Application application, AccountManager accountManager) {
    this.application = application;
    this.accountManager = accountManager;
  }

  @Override
  public Credential authenticate(Proxy proxy, URL url, List<Challenge> challenges)
      throws IOException {
    
    if (url.getPath().startsWith("/oauth")) return null;

    for (Challenge challenge : challenges) {
      if (challenge.getScheme().equals("Bearer")) {
        Account[] accounts = accountManager.getAccountsByType(AuthConstants.ACCOUNT_TYPE);
        if (accounts.length != 0) {
          String oldToken = accountManager.peekAuthToken(accounts[0],
              AuthConstants.AUTHTOKEN_TYPE);
          if (oldToken != null) {
            Timber.d("invalidating auth token");
            accountManager.invalidateAuthToken(AuthConstants.ACCOUNT_TYPE, oldToken);
          }
          try {
            Timber.d("calling accountManager.blockingGetAuthToken");
            String token = accountManager.blockingGetAuthToken(accounts[0],
                AuthConstants.AUTHTOKEN_TYPE, false);

            if(token==null) {
              accountManager.removeAccount(accounts[0], null, null);
            }

            
            
            
            
            if (token != null) {
              return token(token);
            }
          } catch (OperationCanceledException e) {
            e.printStackTrace();
          } catch (AuthenticatorException e) {
            e.printStackTrace();
          }
        }
      }
    }
    return null;
  }

  private Credential token(String token) {
    try {
      
      Constructor<?> constructor = Credential.class.getDeclaredConstructor(String.class);
      Assert.assertTrue(Modifier  .isPrivate(constructor.getModifiers()));
      constructor.setAccessible(true);
      return (Credential) constructor.newInstance("Bearer " + token);
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Credential authenticateProxy(Proxy proxy, URL
      url, List<Challenge> challenges) throws IOException {
    return null;
  }
}
