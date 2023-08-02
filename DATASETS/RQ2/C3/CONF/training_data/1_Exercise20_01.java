

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Exercise20_01 {

    public static void main(String... args) {
        String fileName = "resources/W.txt";
        Exercise20_01 exercise2001 = new Exercise20_01();
        File file = new File(".");
        try {
            file = exercise2001.getFileFromResources(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(":(" + " " + e.getLocalizedMessage());
        }

        List<String> words = new ArrayList<>();

        try (Scanner fileInput = new Scanner(file)) {
            while (fileInput.hasNext()) {
                words.add(fileInput.next());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(words);

    }

    private File getFileFromResources(String fileName) throws URISyntaxException, FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceFile = classLoader.getResource(fileName);
        if (resourceFile == null) {
            System.out.println("File Not Found");
            throw new FileNotFoundException("File not found");
        }
        return new File(resourceFile.toURI());
    }
}
