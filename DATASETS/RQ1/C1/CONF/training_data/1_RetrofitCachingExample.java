/*
 * Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    // Create a web server. MockWebServer is good. Use it.
    MockWebServer mockWebServer = new MockWebServer();
    mockWebServer.play();

    // Create an HTTP client that uses a cache on the file system. Android applications should use
    // their Context to get a cache directory.
    OkHttpClient okHttpClient = new OkHttpClient();
    File cacheDir = new File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString());
    HttpResponseCache cache = new HttpResponseCache(cacheDir, 1024);
    okHttpClient.setResponseCache(cache);

    // Create a Retrofit RestAdapter for our SodaService interface.
    Executor executor = Executors.newCachedThreadPool();
    RestAdapter restAdapter = new RestAdapter.Builder()
        .setExecutors(executor, executor)
        .setClient(new OkClient(okHttpClient))
        .setServer(mockWebServer.getUrl("/").toString())
        .build();
    SodaService sodaService = restAdapter.create(SodaService.class);

    // /pepsi hits the web server and returns a response that will be fully cached for 60 seconds.
    mockWebServer.enqueue(new MockResponse()
        .addHeader("Cache-Control: max-age=60")
        .setBody("\"You got the right one, baby\""));
    assertThat(sodaService.cola("pepsi")).isEqualTo("You got the right one, baby");
    assertThat(cache.getRequestCount()).isEqualTo(1);
    assertThat(cache.getNetworkCount()).isEqualTo(1);
    assertThat(cache.getHitCount()).isEqualTo(0);

    // /coke hits the web server and returns a response that will be conditionally cached.
    mockWebServer.enqueue(new MockResponse()
        .addHeader("ETag: v1")
        .setBody("\"Always Coca-Cola\""));
    assertThat(sodaService.cola("coke")).isEqualTo("Always Coca-Cola");
    assertThat(cache.getRequestCount()).isEqualTo(2);
    assertThat(cache.getNetworkCount()).isEqualTo(2);
    assertThat(cache.getHitCount()).isEqualTo(0);

    // /pepsi returns a response from the cache.
    assertThat(sodaService.cola("pepsi")).isEqualTo("You got the right one, baby");
    assertThat(cache.getRequestCount()).isEqualTo(3);
    assertThat(cache.getNetworkCount()).isEqualTo(2);
    assertThat(cache.getHitCount()).isEqualTo(1);

    // /coke validates the cached response. The server says the cached version is still good.
    mockWebServer.enqueue(new MockResponse()
        .setResponseCode(304));
    assertThat(sodaService.cola("coke")).isEqualTo("Always Coca-Cola");
    assertThat(cache.getRequestCount()).isEqualTo(4);
    assertThat(cache.getNetworkCount()).isEqualTo(3);
    assertThat(cache.getHitCount()).isEqualTo(2);

    mockWebServer.shutdown();
  }
}
