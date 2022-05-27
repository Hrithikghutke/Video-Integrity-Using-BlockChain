/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;


import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author welcome
 */
public class UploadFile {
    
    public void uploaddropboxFile(DbxClientV2 client,String path) throws FileNotFoundException, DbxException, UploadErrorException, IOException
    {
        InputStream in = new FileInputStream(path);
                try 
        {
            
            File ff=new File(path);
            String fname=ff.getName();
            fname="/"+fname;
            
    FileMetadata metadata = client.files().uploadBuilder(fname).uploadAndFinish(in);
    
      System.out.println("File Uploaded Successfully");
        }

                catch (Exception e)
                {
                     System.out.println("Error in Dropbox Upload File Class"+e);
                }
    }
            
    
}
