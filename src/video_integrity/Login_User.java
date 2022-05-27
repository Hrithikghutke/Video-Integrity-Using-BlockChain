/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package video_integrity;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class Login_User {
    public boolean isInserted(String uid, String pw)
    {
        boolean flag = false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/video_integrity","root","root");
            Statement st = con.createStatement();
            String query = "Select * from user_info where uid = '"+uid+"' and pw = '"+pw+"'";
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                flag = true;
            }
            else 
            {
                flag = false;
            }
        }
        catch (Exception ex)
        {
            System.out.println("Exception is "+ex);
        }
        return flag;
    }
    
}
