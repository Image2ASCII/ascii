package com.github.image2ascii.ascii;

import java.awt.image.BufferedImage;

/**
 * Choose an ASCII character based on an Image.
 * @author Ed
 */
public interface CharPicker {
    public Pair<Character,Integer> bestMatch(BufferedImage img);
}
