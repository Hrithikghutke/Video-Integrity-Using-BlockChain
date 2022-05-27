/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package video_integrity;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Data_Fetcher_User {
    public ArrayList toFetch(String uid)
    {
        ArrayList al = new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/video_integrity","root","root");
            Statement st = con.createStatement();
            //name, email, mobile, userid, password
            String query = "select * from user_info where uid = '" +uid+ "' ";
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                al.add(rs.getString(1));
                al.add(rs.getString(2));
                al.add(rs.getString(3));
                al.add(rs.getString(4));
                al.add(rs.getString(5));
            }
            
//            System.out.println(al);
        }
        
        catch (Exception ex)
        {
            System.out.println("Exception is "+ex);
        }
        return al;
    }
    
}
