/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity;

import blockchain.BlockHeadCreator;
import blockchain.BlockHeadSupporter;
import blockchain.Encrypter;
import com.dropbox.core.DbxException;
import static com.dropbox.core.v2.teamlog.AssetLogInfo.folder;
import dropbox.UploadHelper;
import frames.FrameProcess;
import frames.ResultDirectory;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import video_integrity.Check_Integrity;
import video_integrity.CurrentDate;
import video_integrity.CurrentTime;
import video_integrity.Insert_videoinfo;
import video_integrity.Login_Frame;
import video_integrity.Result_Keeper;
import video_integrity.Upload_Frame;

/**
 *
 * @author HP
 */
public class DownloadFile_FrameExtract_IntCheck 
{
    public String getHeadkey(String vpath, String frpath)
    {

        String headkey="";
        //String filename = DownloadFile_Integrity_Check.fname;
                FrameSupporterInt.dir=frpath;
             
               if(new FrameProcessInt().startProcess(vpath))
                {
                    System.out.println();
                    File dirpath=new File(frpath);
                    File lf[]=dirpath.listFiles();
//                    System.out.println("Frames Extracted Successfully!!");
                    
                    for (int i = 0; i < lf.length; i++)
                    {
                        String fpath=lf[i].getAbsolutePath();
                     
                        
                        String blockhead=new BlockHeadCreator().getBlockHead(fpath,headkey);
                        String sbkey=new BlockHeadSupporter().getKey(blockhead);
                        
                        String ekey=new Encrypter().getEncryptedKey(sbkey);
                        headkey=ekey;

                       
                                
                                
                    }
                     
                    
                    System.out.println("Frames from downloaded video successfully Extracted");
                    
                      String tstr=Check_Integrity.jTextArea1.getText();
                   tstr=tstr+"Frames from downloaded video successfully Extracted";
                   Check_Integrity.jTextArea1.setText(tstr);
//                     Insert_videoinfo id = new Insert_videoinfo();
//                  if(id.isInserted(filename, time, Login_Frame.uid, headkey))
//                 JOptionPane.showMessageDialog(null, "Your video is successfully secured through Blockchain and uploaded to Cloud");
//                        
//                else
//                    JOptionPane.showMessageDialog(null, "Error Occured Please Try Again");   
                
                }
//                else
//                    System.out.println("Frame Process initiation failed!!");
                return headkey;
    }
}
