/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class BlockHeadCreator 
{
public String getBlockHead(String path,String headkey)
{
  
       File file = new File(path);
    // Using java.io.FileInputStream
                        byte[] bArray = readFileToByteArray(file);
    //displaying content of byte array
                        String str = "";
                        for (int j = 0; j < bArray.length; j++)
                        {
                            char s = (char)bArray[j];
                            String str1 = Character.toString(s);
                            str = str + str1;
                        }  
                        
                        str=str+headkey;
                        md5 md = new md5();
                        String str5 = md.MDfive(str);
                       // System.out.println(str5);
                        
                        return str5;
}

 private static byte[] readFileToByteArray(File file)
 {
    FileInputStream fis = null;
    // Creating a byte array using the length of the file
    // file.length returns long which is cast to int
    byte[] bArray = new byte[(int) file.length()];
    try{
      fis = new FileInputStream(file);
      fis.read(bArray);
      fis.close();                   
    }catch(IOException ioExp){
      ioExp.printStackTrace();
    }
    return bArray;
  }
}
