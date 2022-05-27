/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dropbox;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.users.FullAccount;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Lenovo
 */
public class FileListHelper
{
       
private static final String ACCESS_TOKEN = "sl.BIRjdPscDFkz7qgLEGzPW6pFljR8ylkIYHsCptqNGh9Mx-cQ3WkK04Yz36-CO8xSP2TjLWfEZKgnCJDbxVR2wBjLl45RTnbrkPBN3Youj5PTUoNE7Yqa4aAAJO95zTXxeEfuavU";

public ArrayList getFileList() throws DbxException, UploadErrorException, IOException
{
     DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());
        
        
        ArrayList files = new ArrayList();
            ListFolderResult listFolderResult = client.files().listFolder("");
            for (Metadata metadata : listFolderResult.getEntries()) 
            {
                String name = metadata.getName();
             //   System.out.println(name);
                if (name.contains("Feature")) {
                    files.add(name);
                }
            }
            Collections.sort(files, new Comparator<String>() 
            {
                @Override
                public int compare(String s1, String s2) {
                    return s2.compareTo(s1);
                }
            }); 
            
            return files;
}
}
