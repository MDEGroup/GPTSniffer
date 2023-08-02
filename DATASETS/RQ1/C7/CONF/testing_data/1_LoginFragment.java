class LoginFragment extends BaseFragment {
  @Inject AccountManager accountManager;
  @InjectView(R.id.et_email) EditText emailText;
  @InjectView(R.id.et_password) EditText passwordText;
  @InjectView(R.id.sign_in) Button signInButton;
  @Inject @ClientId String clientId;
  @Inject @ClientSecret String clientSecret;

  ...
  

  private void doLogin(final String email, String password) {
    Observable<AccessToken> accessTokenObservable =
        apiService.getAccessTokenObservable(email, password,
            clientId,
            clientSecret);

    subscribe(accessTokenObservable, new EndlessObserver<AccessToken>() {
      @Override public void onNext(AccessToken accessToken) {
        Account account = addOrFindAccount(email, accessToken.refreshToken);
        
        accountManager.setAuthToken(account, AuthConstants.AUTHTOKEN_TYPE, accessToken.accessToken);
        finishAccountAdd(email, accessToken.accessToken, accessToken.refreshToken);
      }

      @Override public void onError(Throwable throwable) {
        Timber.e(throwable, "Could not sign in");
        Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_LONG).show();
      }
    });
  }
  
  private Account addOrFindAccount(String email, String password) {
    Account[] accounts = accountManager.getAccountsByType(AuthConstants.ACCOUNT_TYPE);
    Account account = accounts.length != 0 ? accounts[0] :
        new Account(email, AuthConstants.ACCOUNT_TYPE);

    if (accounts.length == 0) {
      accountManager.addAccountExplicitly(account, password, null);
    } else {
      accountManager.setPassword(accounts[0], password);
    }
    return account;
  }

  private void finishAccountAdd(String accountName, String authToken, String password) {
    final Intent intent = new Intent();
    intent.putExtra(AccountManager.KEY_ACCOUNT_NAME, accountName);
    intent.putExtra(AccountManager.KEY_ACCOUNT_TYPE, AuthConstants.ACCOUNT_TYPE);
    if (authToken != null)
      intent.putExtra(AccountManager.KEY_AUTHTOKEN, authToken);
    intent.putExtra(AccountManager.KEY_PASSWORD, password);
    setAccountAuthenticatorResult(intent.getExtras());
    getActivity().setResult(Activity.RESULT_OK, intent);
    getActivity().finish();

    
    startActivity(new Intent(activityContext, MainActivity.class));
  }

}
