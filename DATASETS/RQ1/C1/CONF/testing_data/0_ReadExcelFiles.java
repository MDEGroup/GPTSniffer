import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static void main(String[] args) {
        try {
            // Open the Excel file
            FileInputStream fis = new FileInputStream("path/to/file.xlsx");
            Workbook workbook = WorkbookFactory.create(fis);
            
            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);
            
            // Iterate through each row
            for (Row row : sheet) {
                // Iterate through each cell
                for (Cell cell : row) {
                    // Print the cell's content
                    System.out.print(cell.toString() + " ");
                }
                System.out.println();
            }
            
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

