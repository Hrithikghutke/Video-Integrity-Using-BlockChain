/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrity;

import dropbox.*;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.users.FullAccount;
import java.io.IOException;

/**
 *
 * @author Lenovo
 */
public class DownLoadHelper_Integrity_Check
{
       
private static final String ACCESS_TOKEN = "sl.BIRjdPscDFkz7qgLEGzPW6pFljR8ylkIYHsCptqNGh9Mx-cQ3WkK04Yz36-CO8xSP2TjLWfEZKgnCJDbxVR2wBjLl45RTnbrkPBN3Youj5PTUoNE7Yqa4aAAJO95zTXxeEfuavU";

public void intiateDownload(String filename) throws DbxException, UploadErrorException, IOException
{
     DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        FullAccount account = client.users().getCurrentAccount();
        //System.out.println(account.getName().getDisplayName());
    
        
        DownloadFile_Integrity_Check df=new DownloadFile_Integrity_Check();
        df.downloadDropboxFile(client,filename);
        
        
}
}
