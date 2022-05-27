/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.util.ArrayList;


public class Encrypter 
{
  
    public String getEncryptedKey(String blockhead)
    {
         ArrayList mas=new ArrayList();
         int m = 0, count=0;
        String block="";
        for (int k = 0; k < blockhead.length(); k++)
        {
            char ch=blockhead.charAt(k);
            if(count<4)
            {
                String st=Character.toString(ch);
                block=block+st;
                count++;
            }
            else
            {
                //m = mas.size() + 1;
                mas.add(block);
                block="";
                count=0;
                String st=Character.toString(ch);
                block=block+st;
                count++;
            }
        }
          mas.add(block);
          String ctext="";
         for (int i = 0; i < mas.size(); i++)
         {
            String str=(String)mas.get(i);
            
            String rstr=new Rotate().rotateString(str, i+1);
            String cstr=getcipherKey(rstr);
            // System.out.println(rstr); 
            ctext=ctext+cstr;
         }
         
         
         return ctext;
    }
    
    public String getcipherKey(String str)
    {
        String cstr="";
        
        for (int i = 0; i < str.length(); i++)
        {
            char ch=str.charAt(i);
            int t=(int)ch+56;
            char nch=(char)t;
            cstr=cstr+Character.toString(nch);
            
            
        }
        return cstr;
    }
}
