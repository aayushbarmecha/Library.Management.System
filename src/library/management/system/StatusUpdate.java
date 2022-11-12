package library.management.system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StatusUpdate {
    private int bookId;
    private int compareDate;
    private DateTimeFormatter formatter;
    public void checkStatus(){
        try {
            formatter = DateTimeFormatter.ofPattern("MMM d, y");
            conn con = new conn();
            String sql = "SELECT book_id, dateOfIssue, dateOfExpectedReturn FROM issueBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                bookId = rs.getInt("book_id");

                String issueDate = rs.getString("dateOfIssue");
                String returnDate = rs.getString("dateOfExpectedReturn");

                LocalDate getDate = LocalDate.now();
                String dateNow = getDate.format(formatter);

                LocalDate now = LocalDate.parse(dateNow, formatter);
                LocalDate ret = LocalDate.parse(returnDate, formatter);

                compareDate = now.compareTo(ret);
                    if(compareDate>0){
                        try {
                            String sql2 = "UPDATE issueBook SET status=? WHERE book_id="+bookId;
                            PreparedStatement st2 = con.c.prepareStatement(sql2);
                            st2.setString(1, "Overdue");
                            st2.executeUpdate();
                        }catch (Exception e){
                            System.out.println(e);
                        }
                    } else {
                        try {
                            String sql2 = "UPDATE issueBook SET status=? WHERE book_id="+bookId;
                            PreparedStatement st2 = con.c.prepareStatement(sql2);
                            st2.setString(1, "Waiting for return");
                            st2.executeUpdate();
                        }catch (Exception e){
                            System.out.println(e);
                        }
                    }
            }
            rs.close();
            st.close();
            con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
