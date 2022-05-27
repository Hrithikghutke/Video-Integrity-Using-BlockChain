/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video_integrity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class View_Download_Files 
{
    public void getAll()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/video_integrity","root","root");
            Statement st1 = con.createStatement();
            Statement st2 = con.createStatement();
            
            String query = "Select * from download_info";
            ResultSet rs1 =  st1.executeQuery(query);
            ResultSet rs2 =  st2.executeQuery(query);
            int row = 0;
            while(rs1.next())
            {
                row++;
            }
            int i = 0;
            String[][] data = new String [row][3];
            while(rs2.next())
            {
                String video_name = rs2.getString(1);
                String time = rs2.getString(2);
                String userid = rs2.getString(3);
                
                data[i][0] = video_name;
                data[i][1] = time;
                data[i][2] = userid;
                
                i++;
            }
            View_History.data1 = data;
        }
        catch (Exception ex)
        {
            System.out.println("Exception is "+ex);
        }
    }
}
