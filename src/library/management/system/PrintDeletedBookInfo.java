package library.management.system;

import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class PrintDeletedBookInfo {
    public void export(){
        try {
            conn con = new conn();
            String sql = "SELECT * FROM deleted_book";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("Book Information");

            writeHeaderLine(sheet);
            writeDataLines(rs, wb, sheet);

            String outputPath = System.getProperty("user.home")+"\\Documents";
            FileOutputStream output = new FileOutputStream(outputPath+"\\DeletedBookInformation.xlsx");
            wb.write(output);
            output.close();

            JOptionPane.showMessageDialog(null,"Deleted Book Information has been exported to "+outputPath+"\nFilename: DeletedBookInformation.xlsx", "Export Success",JOptionPane.PLAIN_MESSAGE);
            
            con.closeConnection();
        } catch (Exception e){
            System.out.println("Error: ");
            e.printStackTrace();
        }
    }

    private void writeHeaderLine(XSSFSheet sheet){
        Row headerRow = sheet.createRow(0);
 
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("ISBN");
 
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Book Name");
 
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Publisher");
 
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Edition");

        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Price");

        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Pages");
    }

    private void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet) throws SQLException{
        int rowCount = 1;

        while(result.next()){
            String bookISBN = result.getString("isbn");
            String bookName = result.getString("name");
            String bookPublisher = result.getString("publisher");
            String bookEdition = result.getString("edition");
            String bookPrice = result.getString("price");
            String bookPages = result.getString("pages");

            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;

            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(bookISBN);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(bookName);

            cell = row.createCell(columnCount++);
            cell.setCellValue(bookPublisher);

            cell = row.createCell(columnCount++);
            cell.setCellValue(bookEdition);

            cell = row.createCell(columnCount++);
            cell.setCellValue(bookPrice);

            cell = row.createCell(columnCount++);
            cell.setCellValue(bookPages);
        }
    }
}
