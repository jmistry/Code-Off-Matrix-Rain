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
        this.y = (-1) * length * Config.FONT_SIZE;
    }

    private char[][] createContent(String tweetString) {
        int tweetLength = tweetString.length();
        char[][] result = new char[tweetLength][1];
        for (int i = 0; i < tweetLength; i++) {
            result[i][0] = tweetString.charAt(i);
        }
        return result;
    }



    public void draw(Graphics2D g2) {
        int fontSize = g2.getFont().getSize();
        for (int i = 0; i < length; i++) {
//            if (getRandomInteger(0, length) == i)
//                text[i][0] = getRandomCharacter();
            if (i == length - 1)
                g2.setColor(new Color(253, 104, 25));
//            else
//                g2.setColor(new Color(66, 198, 255));
            g2.drawChars(text[i], 0, 1,  y + (i * fontSize),x);
        }
        y += velocity;
    }

    public char getRandomCharacter() {
        return (char) (rng.nextInt(26) + 'a');
    }

    public int getRandomInteger(int min, int max) {
        int randomNum = rng.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public boolean isOffScreen() {
        return (y > Config.SCREEN_SIZE);
    }

    /*public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char[][] getText() {
        return text;
    }

    public void setText(char[][] text) {
        this.text = text;
    }*/
}