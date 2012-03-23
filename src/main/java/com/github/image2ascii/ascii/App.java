package com.github.image2ascii.ascii;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


public class App 
{
    private static String gs = "";

            
    public static void main( String[] args ) throws IOException
    {
        BufferedImage img = null;
        File f;
        if (args.length < 1) {
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            f = jfc.getSelectedFile();
        } else {
            try {
                f = new File(args[0]);
                if (!f.exists()) {
                    System.err.println("File doesn't exist!");
                    return;
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return;
            }
        }
        
        
        
        
        try{
            img = ImageIO.read(f);
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        Mapper m = new Mapper(img, new GrayscaleCharPicker(), new TextTransformer());
        String[] lines = m.getLines(300);
        for (String s : lines) {
           // PrintWriter out = new PrintWriter("testName.txt");
            //out.println(s);
            
            gs += s + "\r\n";
        }

        Writer output = null;
            
            File file = new File("output.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(gs);
            output.close();
    }
}
