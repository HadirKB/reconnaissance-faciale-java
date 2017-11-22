package MVC;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Test {
    public static void main(String[] args) {
        Vector original = testImg("C:/Users/Public/Pictures/69.jpg");
        Vector clonde   = testImg("C:/Users/Public/Pictures/194.jpg");
        System.out.println(original.equals(clonde));

    }

    public static Vector testImg(String file) {
        Vector all = new Vector();
        //eyes
        //nose
        //mouth
        
        try {
            BufferedImage im = ImageIO.read(new FileInputStream(file));
            int w = im.getWidth(null);
            int h = im.getHeight(null);
            int[] rgbs = new int[w * h];
            int x = 0;
            im.getRGB(0, 0, w, h, rgbs, 0, w);

            for (int i = 0; i < w; i+=100) {
                Vector line = new Vector();
                for (int j = 0; j < h; j+=100) {
                    line.add(new Integer(rgbs[x]));
                    //System.out.println("Pixel " + i + "," + j + "has " +
                    //                   "RGB values of " + rgbs[x]);
                    x++;
                }
                all.add(line);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return all;
    }
  


}