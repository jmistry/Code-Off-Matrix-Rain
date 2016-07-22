package com.prolificidea.codeoff;

import java.awt.*;
import java.util.Random;

public class Drop {

    private Random rng = new Random();
    private int velocity, length, x, y;
    private char[][] text;

    Drop(int x, String tweetString) {
        this.x = x;
        length = tweetString.length();
        text = createContent(tweetString);
        velocity = getRandomInteger(1, 5);
        this.y = (+1) * length * Config.FONT_SIZE;
    }

    private char[][] createContent(String tweetString) {
        int tweetLength = tweetString.length();
        char[][] result = new char[tweetLength][1];
        for (int i = 0; i < tweetLength; i++) {
            result[i][0] = tweetString.charAt(i);
        }
        return result;
    }

    public void draw(Graphics2D g2, com.prolificidea.codeoff.SimpleImage simpleImage) {
        int fontSize = g2.getFont().getSize();
        int blockSize = Config.SCREEN_SIZE / Config.FONT_SIZE;
        for (int i = 0; i < length; i++) {
            g2.setColor(new Color(253, 104, 25));
            if (y > 0 && y < Config.SCREEN_SIZE && simpleImage.getBlockImage()[x / blockSize][y / blockSize]) {
                g2.setColor(new Color(66, 198, 255));
            }
            g2.drawChars(text[i], 0, 1, x, y + (i * fontSize));
        }
        y -= velocity;
    }

    public int getRandomInteger(int min, int max) {
        int randomNum = rng.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public boolean isOffScreen() {
        return y + text.length < 0;
    }

}