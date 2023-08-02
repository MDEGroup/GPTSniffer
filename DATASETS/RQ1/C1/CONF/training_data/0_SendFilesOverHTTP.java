import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import java.io.File;
import java.io.IOException;

public class HttpFileSender {
    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://example.com/upload");
        File file = new File("path/to/file.txt");

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", file);
        HttpEntity multipart = builder.build();

        httpPost.setEntity(multipart);
        HttpResponse response = httpClient.execute(httpPost);
    }
}

