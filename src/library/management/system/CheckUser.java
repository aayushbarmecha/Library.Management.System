package library.management.system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckUser {
    public String checkUser(){
        String username="";
        try {
            conn con = new conn();
            String sql = "SELECT * FROM login WHERE accNo=1";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                username = rs.getString("account");
            }
            con.closeConnection();
        } catch (Exception e){
            System.out.println(e);
        }
        return username;
    }
}
