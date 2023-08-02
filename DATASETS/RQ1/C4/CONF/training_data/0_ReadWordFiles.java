import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class WordReader {
    public static void main(String[] args) {
        try {
            
            File file = new File("path/to/file.docx");
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument document = new XWPFDocument(fis);
            
            
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            
            
            for (XWPFParagraph paragraph : paragraphs) {
                System.out.println(paragraph.getText());
            }
            
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

