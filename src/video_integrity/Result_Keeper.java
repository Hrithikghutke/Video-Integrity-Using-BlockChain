/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video_integrity;

/**
 *
 * @author HP
 */
public class Result_Keeper 
{
    
    
//    public static String filename1="";
    public String dispResult(String filename, String tkey, String hkey)
    {
        String str = "";
        if(tkey.equals(hkey))
            str = "\n"+filename+"\nDownloaded Successfully from Cloud\n"+"Frames from downloaded video successfully Extracted"+"\nTerminal Key Successfully Created : "+tkey+"\nHeadkey matched!! Integrity of "+filename+" is Intact\n"+"\n===========================================================\n";
        else
            str = "\n"+filename+"\nDownloaded Successfully from Cloud\n"+"Frames from downloaded video successfully Extracted"+"Terminal Key Successfully Created : "+tkey+"\nHeadkey mismatch!! Integrity of "+filename+" is Compromised\n"+"\n===========================================================\n";

        return str;
    }
}
