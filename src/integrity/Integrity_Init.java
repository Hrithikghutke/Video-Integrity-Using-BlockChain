/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import video_integrity.Check_Integrity;
import static video_integrity.Check_Integrity.jTextArea1;
import video_integrity.Login_User;
import video_integrity.Operations_Frame;
import video_integrity.Result_Keeper;
import video_integrity.User_Update;

/**
 *
 * @author HP
 */
public class Integrity_Init 
{
    public static String username = "";
    public void runIntegrityProcessNow()
    {
       // while(true)
        {
            Data_Fetcher_User_Video df  = new Data_Fetcher_User_Video();
            ArrayList al = df.toFetch(username);
            String res = "";
            //System.out.println("AL is: "+al);
            for (int i = 0; i < al.size(); i++) 
            {
                ArrayList temp = (ArrayList)al.get(i);
                String filename = (String)temp.get(0);
                String terminalkey = (String)temp.get(1);
                
                Download_Store_Video dsv = new Download_Store_Video();
                if(dsv.download_video_cloud(filename))
                {
                   System.out.println(filename+" Downloaded Successfully from Cloud");
//                   String tstr=Check_Integrity.jTextArea1.getText();
//                   tstr=tstr+filename+" Downloaded Successfully from Cloud";
//                   Check_Integrity.jTextArea1.setText(tstr);
                   
//                   String str=Result_Keeper.filename1+" Downloaded Successfully from Cloud ";
//                     Check_Integrity.jTextArea1.setText(str);
                   try
                   {
                       Thread.sleep(3000);
                   }
                   catch(Exception ex)
                   {
                       System.out.println("Exception after Downloading file "+ex);
                   }
                    String vpath = "D://temp//"+filename;
                    String frpath = "D://temp//Frames";
                    File folder1=new File(frpath);
                    if(!folder1.exists())
                    folder1.mkdirs();
                
                    
                    DownloadFile_FrameExtract_IntCheck gh = new DownloadFile_FrameExtract_IntCheck();
                    String headkey = gh.getHeadkey(vpath, frpath);
                    Result_Keeper rk = new Result_Keeper();
                    String res1 =rk.dispResult(filename, terminalkey, headkey);
                    res = res + res1;
                    Check_Integrity.jTextArea1.setText(res);
                    System.out.println("Terminal Key Successfully Created : "+headkey);
//                    String tstr1=Check_Integrity.jTextArea1.getText();
//                   tstr1=tstr1+"Terminal Key Successfully Created : "+headkey;
//                   Check_Integrity.jTextArea1.setText(tstr1);
//                    System.out.println("TerminalKey was: "+terminalkey);
                    if(headkey.equals(terminalkey))
                    {
                        //JOptionPane.showMessageDialog(null, "Headkey matched!!\nIntegrity of "+filename+"  is Intact");
                        System.out.println("Headkey matched!! Integrity of "+filename+" is Intact");
//                      String tstr2=Check_Integrity.jTextArea1.getText();
//                      tstr2=tstr2+"Headkey matched!! Integrity of "+filename+" is Intact";
//                      Check_Integrity.jTextArea1.setText(tstr2);
                    }
                    else
                    {
                        //JOptionPane.showMessageDialog(null, "Alert!!!\nHeadkey Mismatch!!\nIntegrity of "+filename+" is Compromised");
                        System.out.println("Alert!!!Headkey mismatch!! Integrity of "+filename+" is Compromised");
//                        String tstr2=Check_Integrity.jTextArea1.getText();
//                        tstr2=tstr2+"Alert!!!Headkey mismatch!! Integrity of "+filename+" is Compromised";
//                        Check_Integrity.jTextArea1.setText(tstr2);
                    }
                    Delete_Files del = new Delete_Files();
                    del.delete_files();
                    
                }
                
                  System.out.println("\n =========================================================== \n");
            }
            try
            {
                Thread.sleep(2000);
            }
            catch (Exception ex)
                    {
                        
                    }
            
          
        }
    }
}
