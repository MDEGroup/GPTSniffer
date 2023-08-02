
public interface ApiService {
  
  @FormUrlEncoded
  @POST("/oauth/token?grant_type=password") AccessToken getAccessToken(
      @Field("username") String email,
      @Field("password") String password,
      @Field("client_id") String clientId,
      @Field("client_secret") String clientSecret);

  @FormUrlEncoded
  @POST("/oauth/token?grant_type=refresh_token") AccessToken refreshAccessToken(
      @Field("refresh_token") String refreshToken,
      @Field("client_id") String clientId,
      @Field("client_secret") String clientSecret);

  @FormUrlEncoded
  @POST("/oauth/token?grant_type=password") Observable<AccessToken> getAccessTokenObservable(
      @Field("username") String email,
      @Field("password") String password,
      @Field("client_id") String clientId,
      @Field("client_secret") String clientSecret);
}