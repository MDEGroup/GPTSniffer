
public class FileUploader {
    public static void main(String[] args) {
        String url = "http:
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

