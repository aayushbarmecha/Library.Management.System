package library.management.system;

import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class PrintStudentInfo {
    public void export(){
        try {
            conn con = new conn();
            String sql = "SELECT * FROM student";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("Student Information");

            writeHeaderLine(sheet);
            writeDataLines(rs, wb, sheet);

            String outputPath = System.getProperty("user.home")+"\\Documents";
            FileOutputStream output = new FileOutputStream(outputPath+"\\StudentInformation.xlsx");
            wb.write(output);
            output.close();

            JOptionPane.showMessageDialog(null,"Student Information has been exported to "+outputPath+"\nFilename: StudentInformation.xlsx", "Export Success",JOptionPane.PLAIN_MESSAGE);
            
            con.closeConnection();
        } catch (Exception e){
            System.out.println("Error: ");
            e.printStackTrace();
        }
    }

    private void writeHeaderLine(XSSFSheet sheet){
        Row headerRow = sheet.createRow(0);
 
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Student ID");
 
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("First Name");
 
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Last Name");
 
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Course");
 
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Contact Info");
    }

    private void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet) throws SQLException{
        int rowCount = 1;

        while(result.next()){
            int studentID = result.getInt("student_id");
            String firstName = result.getString("fname");
            String lastName = result.getString("lname");
            String studentCourse = result.getString("course");
            String contactInfo = result.getString("contact_info");

            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;

            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(studentID);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(firstName);

            cell = row.createCell(columnCount++);
            cell.setCellValue(lastName);

            cell = row.createCell(columnCount++);
            cell.setCellValue(studentCourse);

            cell = row.createCell(columnCount++);
            cell.setCellValue(contactInfo);
        }
    }
}
