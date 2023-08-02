


@SuppressLint("Registered") public class BaseActivity extends FragmentActivity
    implements OnAccountsUpdateListener {
  @Inject AppContainer appContainer;
  @Inject ScopedBus bus;
  @Inject AccountManager accountManager;

  private ViewGroup container;
  private ObjectGraph activityGraph;

  private SubscriptionManager<Activity> subscriptionManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    buildActivityGraphAndInject();

    
    Dart.inject(this);
  }

  private void buildActivityGraphAndInject() {
    
    App app = App.get(this);
    activityGraph = app.getApplicationGraph().plus(getModules().toArray());

    
    activityGraph.inject(this);

    container = appContainer.get(this, app);
  }

  
  public void inject(Object o) {
    activityGraph.inject(o);
  }

  
  protected List<Object> getModules() {
    return Arrays.<Object>asList(new ActivityModule(this));
  }

  @Override protected void onResume() {
    super.onResume();
    bus.resumed();
    bus.register(this);

    
    if(requireLogin()) accountManager.addOnAccountsUpdatedListener(this, null, true);
  }

  @Override protected void onPause() {
    bus.unregister(this);
    bus.paused();

    if(requireLogin()) accountManager.removeOnAccountsUpdatedListener(this);

    super.onPause();
  }

  protected boolean requireLogin() {
    return true;
  }

  @Override protected void onDestroy() {
    
    
    activityGraph = null;
    if(subscriptionManager!=null) subscriptionManager.unsubscribeAll();

    super.onDestroy();
  }

  protected void inflateLayout(int layoutResID) {
    getLayoutInflater().inflate(layoutResID, container);
    
    ButterKnife.inject(this);
  }

  public static BaseActivity get(Fragment fragment) {
    return (BaseActivity) fragment.getActivity();
  }

  @Override public void onAccountsUpdated(Account[] accounts) {
    for (Account account : accounts) {
      if (AuthConstants.ACCOUNT_TYPE.equals(account.type)) {
        return;
      }
    }

    
    Intent intent = new Intent(this, AuthenticatorActivity.class);
    startActivity(intent);
    finish();
  }

  protected <O> Subscription subscribe(final Observable<O> source, final Observer<O> observer) {
    if (subscriptionManager == null) {
      subscriptionManager = new ActivitySubscriptionManager(this);
    }
    return subscriptionManager.subscribe(source, observer);
  }
}
