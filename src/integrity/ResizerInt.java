

package integrity;


import frames.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ResizerInt
{

    public BufferedImage resize(BufferedImage img) throws IOException
    {
         BufferedImage image2;


           int h=img.getHeight();
           int w=img.getWidth();


        image2=new BufferedImage(400,400,img.getType());
      Graphics2D gr2 = image2.createGraphics();
      gr2.drawImage(img,0,0,400,400,0,0,w,h,null);
      gr2.dispose();

//      String path="E:/test/"+name;
//      System.out.println("path is "+path);
//      
//          ImageIO.write(image2, "jpg", new File(path));

         

         return image2;

    }
}
