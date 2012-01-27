package info.kellett.ed.ascii;

import java.awt.image.BufferedImage;

/**
 * Choose an ASCII character based on an Image.
 * @author Ed
 */
public interface CharPicker {
    public char bestMatch(BufferedImage img);
}
