import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class WordReader {
    public static void main(String[] args) {
        try {
            // Open the Word file
            File file = new File("path/to/file.docx");
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument document = new XWPFDocument(fis);
            
            // Get the paragraphs
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            
            // Print the text of each paragraph
            for (XWPFParagraph paragraph : paragraphs) {
                System.out.println(paragraph.getText());
            }
            
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

