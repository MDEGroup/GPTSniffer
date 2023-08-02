

import com.google.mockwebserver.MockResponse;
import com.google.mockwebserver.MockWebServer;
import com.squareup.okhttp.HttpResponseCache;
import com.squareup.okhttp.OkHttpClient;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Path;

import static org.fest.assertions.api.Assertions.assertThat;

public class RetrofitCachingExample {
  interface SodaService {
    @GET("/{brand}") Object cola(@Path("brand") String brand);
  }

  public static void main(String[] args) throws Exception {
    
    MockWebServer mockWebServer = new MockWebServer();
    mockWebServer.play();

    
    
    OkHttpClient okHttpClient = new OkHttpClient();
    File cacheDir = new File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString());
    HttpResponseCache cache = new HttpResponseCache(cacheDir, 1024);
    okHttpClient.setResponseCache(cache);

    
    Executor executor = Executors.newCachedThreadPool();
    RestAdapter restAdapter = new RestAdapter.Builder()
        .setExecutors(executor, executor)
        .setClient(new OkClient(okHttpClient))
        .setServer(mockWebServer.getUrl("/").toString())
        .build();
    SodaService sodaService = restAdapter.create(SodaService.class);

    
    mockWebServer.enqueue(new MockResponse()
        .addHeader("Cache-Control: max-age=60")
        .setBody("\"You got the right one, baby\""));
    assertThat(sodaService.cola("pepsi")).isEqualTo("You got the right one, baby");
    assertThat(cache.getRequestCount()).isEqualTo(1);
    assertThat(cache.getNetworkCount()).isEqualTo(1);
    assertThat(cache.getHitCount()).isEqualTo(0);

    
    mockWebServer.enqueue(new MockResponse()
        .addHeader("ETag: v1")
        .setBody("\"Always Coca-Cola\""));
    assertThat(sodaService.cola("coke")).isEqualTo("Always Coca-Cola");
    assertThat(cache.getRequestCount()).isEqualTo(2);
    assertThat(cache.getNetworkCount()).isEqualTo(2);
    assertThat(cache.getHitCount()).isEqualTo(0);

    
    assertThat(sodaService.cola("pepsi")).isEqualTo("You got the right one, baby");
    assertThat(cache.getRequestCount()).isEqualTo(3);
    assertThat(cache.getNetworkCount()).isEqualTo(2);
    assertThat(cache.getHitCount()).isEqualTo(1);

    
    mockWebServer.enqueue(new MockResponse()
        .setResponseCode(304));
    assertThat(sodaService.cola("coke")).isEqualTo("Always Coca-Cola");
    assertThat(cache.getRequestCount()).isEqualTo(4);
    assertThat(cache.getNetworkCount()).isEqualTo(3);
    assertThat(cache.getHitCount()).isEqualTo(2);

    mockWebServer.shutdown();
  }
}
