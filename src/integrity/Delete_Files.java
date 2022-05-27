/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity;
import static com.dropbox.core.v2.teamlog.AssetLogInfo.file;
import java.io.File;
/**
 *
 * @author HP
 */
public class Delete_Files {

    /**
     * @param args the command line arguments
     */
    public static void delete_files() 
    {
      String filePath = "D://temp";
      File file = new File(filePath);
      deleteFolder(file);
      //System.out.println("Files deleted from E://temp");
    }

public static void deleteFolder(File file){
      for (File subFile : file.listFiles()) {
         if(subFile.isDirectory()) {
            deleteFolder(subFile);
         } else {
            subFile.delete();
         }
      }
      file.delete();
   }
}
