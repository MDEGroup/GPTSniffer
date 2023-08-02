// An activity which handles listening to AccountManager changes and invoking AuthenticatorActivity if no account are available
// Also hanldes Dagger injections, provides an Otto bus, and allows subscription to observables 
// while listening to activity lifecycle
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

    // Inject any extras
    Dart.inject(this);
  }

  private void buildActivityGraphAndInject() {
    // Create the activity graph by .plus-ing our modules onto the application graph.
    App app = App.get(this);
    activityGraph = app.getApplicationGraph().plus(getModules().toArray());

    // Inject ourselves so subclasses will have dependencies fulfilled when this method returns.
    activityGraph.inject(this);

    container = appContainer.get(this, app);
  }

  /** Inject the given object into the activity graph. */
  public void inject(Object o) {
    activityGraph.inject(o);
  }

  /**
   * A list of modules to use for the individual activity graph. Subclasses can override this
   * method to provide additional modules provided they call and include the modules returned by
   * calling {@code super.getModules()}.
   */
  protected List<Object> getModules() {
    return Arrays.<Object>asList(new ActivityModule(this));
  }

  @Override protected void onResume() {
    super.onResume();
    bus.resumed();
    bus.register(this);

    // Watch to make sure the account still exists.
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
    // Eagerly clear the reference to the activity graph to allow it to be garbage collected as
    // soon as possible.
    activityGraph = null;
    if(subscriptionManager!=null) subscriptionManager.unsubscribeAll();

    super.onDestroy();
  }

  protected void inflateLayout(int layoutResID) {
    getLayoutInflater().inflate(layoutResID, container);
    // Inject Views
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

    // No accounts so start the authenticator activity
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
