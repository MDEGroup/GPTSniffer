import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;

public class FileUploader {
    public static void main(String[] args) {
        String url = "http://example.com/upload";
        String filePath = "/path/to/file.txt";
        String fileName = "file.txt";

        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);

            FileBody fileBody = new FileBody(new File(filePath), ContentType.DEFAULT_BINARY);
            StringBody fileNameBody = new StringBody(fileName, ContentType.DEFAULT_BINARY);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addPart("file", fileBody);
            builder.addPart("fileName", fileNameBody);
            HttpEntity entity = builder.build();

            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();

            if (responseEntity != null) {
                InputStream inputStream = responseEntity.getContent();
                try {
                    // process the input stream
                } finally {
                    inputStream.close();
                }
            }

        } catch (ClientProtocolException e) {
            Logger.getLogger(FileUploader.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(FileUploader.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

