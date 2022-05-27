/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

public class Rotate
{
public String rotateString(String  str,int n)
    {

   n=n%4;

if(str.length()!=4)
{
    n=str.length();
}
   
 char ch[]=str.toCharArray();
       String  pp="";

         int k=str.length()-n;//3
         for(int j=k;j<str.length();j++)
         {
             String pr=Character.toString(ch[j]);
             pp=pp+pr;
         }

         for(int i=0;i<k;i++)
         {
            String pr=Character.toString(ch[i]);
            pp=pp+pr;
         }
         return (pp);
    }


   }
