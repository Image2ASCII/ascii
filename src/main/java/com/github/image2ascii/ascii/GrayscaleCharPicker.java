package com.github.image2ascii.ascii;

import java.awt.image.BufferedImage;

public class GrayscaleCharPicker implements CharPicker {
    public Pair<Character,Integer> bestMatch(BufferedImage img) {
        double sum, sum1, sum2, sum3;
        sum = 0; sum1 = 0; sum2 = 0; sum3 = 0;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int rgb = img.getRGB(i, j);
                sum1 += (double)(rgb & 0xFF);
                sum2 += (double)((rgb>>8) & 0xFF);
                sum3 += (double)((rgb>>16) & 0xFF);
                double avg = ((double)((rgb & 0xFF) + ((rgb>>8) & 0xFF) + ((rgb>>16) & 0xFF))) / 765.0D;
                sum += avg;
            }
        }
        int size = (img.getWidth() * img.getHeight());
        double average = sum / size;
        double mod = average;
        while (mod > 0.2D) mod -= 0.2D;
        double scale = mod * 2.5D + 0.5D;
        if (scale >= 0.0D && scale < 1.0D) {
            sum1 *= scale; sum2 *= scale; sum3 *= scale;
        }
        int color = (((int)sum1 / size)) | ((((int)sum2 / size) & 0xFF) << 8) | ((((int)sum3 / size) & 0xFF) << 16);
        if (average >= 0.8) {
            return new Pair(' ', color);
        }
        else if (average >= 0.6) {
            return new Pair('.', color);
        }
        else if (average >= 0.4) {
            return new Pair('+', color);
        }
        else if (average > 0.2) {
            return new Pair('$', color);
        }
        else {
            return new Pair('#', color);
        }
    }
}
