

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

