package info.kellett.ed.ascii;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Maps a CharPicker over an Image
 * @author Ed
 */
public class Mapper {
    final BufferedImage img;
    final CharPicker cp;
    
    public Mapper(BufferedImage img, CharPicker cp) {
        this.img = img;
        this.cp = cp;
    }
    
    public String[] getLines(int cols) {
        float fcharx = (float)img.getWidth() / cols;
        int charx = (int)fcharx;
        int chary = (int)(fcharx * 2.6F);
        ArrayList<String> l = new ArrayList<String>();
        for (int j = 0; (j + chary) < img.getHeight(); j += chary) {
            String s = "";
            for (int i = 0; (i + charx) < img.getWidth(); i += charx) {
                s += cp.bestMatch(img.getSubimage(i, j, charx, chary));
            }
            l.add(s);
        }
        return l.toArray(new String[0]);
    }
}
