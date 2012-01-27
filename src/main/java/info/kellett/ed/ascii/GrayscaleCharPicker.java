package info.kellett.ed.ascii;

import java.awt.image.BufferedImage;

public class GrayscaleCharPicker implements CharPicker {
    public char bestMatch(BufferedImage img) {
        double sum = 0;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int rgb = img.getRGB(i, j);
                double avg = ((double)((rgb & 0xFF) + ((rgb>>8) & 0xFF) + ((rgb>>8) & 0xFF))) / 765.0D;
                sum += avg;
            }
        }
        double average = sum / (img.getWidth() * img.getHeight());
        if (average >= 0.8) {
            return ' ';
        }
        else if (average >= 0.6) {
            return '.';
        }
        else if (average >= 0.4) {
            return '+';
        }
        else if (average > 0.2) {
            return '$';
        }
        else {
            return '#';
        }
    }
}
