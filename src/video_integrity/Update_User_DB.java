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
public class Update_User_DB {
    public boolean isInserted(String name, String email, String mob, String userid, String pw)
    {
        boolean flag = false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/video_integrity","root","root");
            Statement st = con.createStatement();//name, email, mobile, uname, password
            String query = "Update user_info set name = '" +name+ "', email = '"+email+"', mob = '"+mob+"', pw = '"+pw+"' where uid = '"+userid+"' ";
            int x = st.executeUpdate(query);
            if(x>0)
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
