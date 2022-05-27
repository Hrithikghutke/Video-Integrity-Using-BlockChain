/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;




//import blockchaindataencryption.FileDownloadFrame;
//import blockchaindataencryption.SearchEngine;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;



/**
 *
 * @author welcome
 */
public class DownloadFile {
    
    public static String Drive="D://DropBoXFiles";
    public void downloadDropboxFile(DbxClientV2 client,String filename) throws FileNotFoundException, DbxException, IOException
    {
        
        File folder=new File(Drive);
        if(!folder.exists())
            folder.mkdirs();
        String path=Drive+"//"+filename;
       String fname="/"+filename;
        
        
         OutputStream downloadFile = new FileOutputStream(path);
                try
                {
                FileMetadata metadata = client.files().downloadBuilder(fname)
                        .download(downloadFile);
                }
                finally
                {
                    downloadFile.close();
                }

//                FileDownloadFrame.path=path;
//                SearchEngine.path=path;

        
    }
    
}
