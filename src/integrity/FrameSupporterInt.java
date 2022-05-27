/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrity;

import frames.*;
import com.xuggle.xuggler.Global;
import com.xuggle.xuggler.IVideoPicture;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;



/**
 *
 * @author Yuga H
 */
public class FrameSupporterInt 
{
    
     /** The number of seconds between frames. */
    
    public static String dir="";

  public static final double SECONDS_BETWEEN_FRAMES = 1;
  
  public static int x=0;

  /** The number of nano-seconds between frames. */

  public static final long NANO_SECONDS_BETWEEN_FRAMES = 
    (long)(Global.DEFAULT_PTS_PER_SECOND * SECONDS_BETWEEN_FRAMES);
  
  /** Time of last frame write. */
  
  private static long mLastPtsWrite = Global.NO_PTS;

 
      public void processFrame(IVideoPicture picture, BufferedImage image)
  {
    try
    {
        
      //  System.out.println("Inside process fram method of FrameSupporter and directory name is "+dir);
      // if uninitialized, backdate mLastPtsWrite so we get the very
      // first frame

      if (mLastPtsWrite == Global.NO_PTS)
        mLastPtsWrite = picture.getPts() - NANO_SECONDS_BETWEEN_FRAMES;

      // if it's time to write the next frame

      if (picture.getPts() - mLastPtsWrite >= NANO_SECONDS_BETWEEN_FRAMES)
      {
        // Make a temorary file name
          
//          File folder=new File("D://Frames");
//          if(!folder.exists())
//              folder.mkdirs();
          x=x+1;
          
          String dsn=dir+"//"+Integer.toString(x)+".jpg";
        //  System.out.println("Dst frame path is "+dsn);
//          String s=Integer.toString(x);
//          String p="D://Frames//"+s+".jpg";
          

      //  File file = File.createTempFile("frame", ".jpg");
        
         File file = new File(dsn);//.createTempFile("frame", ".jpg");

         BufferedImage resimage=new ResizerInt().resize(image);

        ImageIO.write(resimage, "jpg", file);

        // indicate file written

        double seconds = ((double)picture.getPts()) / Global.DEFAULT_PTS_PER_SECOND;
        //System.out.printf("at elapsed time of %f seconds wrote: %s\n",seconds, file);
        
        // update last write time
        
        mLastPtsWrite += NANO_SECONDS_BETWEEN_FRAMES;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
