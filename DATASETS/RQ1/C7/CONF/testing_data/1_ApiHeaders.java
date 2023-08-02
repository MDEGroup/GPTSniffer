public final class ApiHeaders implements RequestInterceptor {

  private Application application;

  @Inject
  public ApiHeaders(Application application) {
    this.application = application;
  }

  @Override
  public void intercept(RequestFacade request) {
    AccountManager accountManager = AccountManager.get(application);
    Account[] accounts = accountManager.getAccountsByType(AuthConstants.ACCOUNT_TYPE);
    if (accounts.length != 0) {
      String token =
          accountManager.peekAuthToken(accounts[0], AuthConstants.AUTHTOKEN_TYPE);
      if (token != null) {
        request.addHeader("Authorization", "Bearer " + token);
      }
    }
    request.addHeader("Accept", "application/javascript, application/json");
  }
}
