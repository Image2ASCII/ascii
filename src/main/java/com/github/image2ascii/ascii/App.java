package com.github.image2ascii.ascii;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class App 
{
    public static void main( String[] args )
    {
        if (args.length < 1) {
            System.err.println("Must supply at least 1 argument!");
            throw new RuntimeException();
        }
        
        BufferedImage img;
        try {
            File f = new File(args[0]);
            if (!f.exists()) {
                System.err.println("File doesn't exist!");
                return;
            }
            img = ImageIO.read(f);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        String[] lines = m.getLines(600);
        System.out.println("<pre style=\"font-size:30%\">");
        for (String s : lines) {
            System.out.println(s);
        }
        System.out.println("</pre>");
    }
}
