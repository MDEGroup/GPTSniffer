
public class ExcelReader {
    public static void main(String[] args) {
        try {
            
            FileInputStream fis = new FileInputStream("path/to/file.xlsx");
            Workbook workbook = WorkbookFactory.create(fis);
            
            
            Sheet sheet = workbook.getSheetAt(0);
            
            
            for (Row row : sheet) {
                
                for (Cell cell : row) {
                    
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

