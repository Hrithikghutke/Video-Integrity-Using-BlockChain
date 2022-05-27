/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video_integrity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class Insert_Dwldvideoinfo 
{
    public boolean isInserted(String filename, String time, String userid)
    {
        boolean flag = false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/video_integrity","root","root");
            Statement st = con.createStatement();
            String query = "Insert into download_info values ('" +filename+ "','"+time+"','"+userid+"') ";
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
