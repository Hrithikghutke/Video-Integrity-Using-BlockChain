/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity;

import com.dropbox.core.DbxException;
import dropbox.DownLoadHelper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import video_integrity.Download_Frame;

/**
 *
 * @author HP
 */
public class Download_Store_Video 
{
    public boolean download_video_cloud(String filename)
    {
        boolean flag = false;
        
        {
        try {
                new DownLoadHelper_Integrity_Check().intiateDownload(filename);
                
                flag = true;
            } catch (DbxException ex) {
                Logger.getLogger(Download_Frame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Download_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
      return flag;
        }
    }
}
