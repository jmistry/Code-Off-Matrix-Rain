package com.prolificidea.codeoff;

import com.prolificidea.codeoff.twitter.TweetSearcher;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Random;

public class Rain extends JPanel {

    private Drop[] drops;
    private Random rng=new Random();
    List<String> tweets;

    Rain() {
        this.tweets = TweetSearcher.getTweets();
        drops = new Drop[Config.SCREEN_SIZE / Config.FONT_SIZE];
        for (int i = 0; i < drops.length; i++) {
            String randomTweet = getRandomTweet();
            drops[i] = new Drop(i * Config.FONT_SIZE, randomTweet);
        }
    }

    private String getRandomTweet() {
        return tweets.get(getRandomInteger(0, tweets.size()-1));
    }

    public int getRandomInteger(int min, int max) {

        int randomNum = rng.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g.fillRect(0, 0, Config.SCREEN_SIZE, Config.SCREEN_SIZE);
        g.setColor(Color.BLACK);
        Font font = new Font("Monospaced", Font.PLAIN, Config.FONT_SIZE);
        g2.setFont(font);

        for (int i = 0; i < drops.length; i++) {
            if (drops[i].isOffScreen()) {
                drops[i] = new Drop(i * Config.FONT_SIZE, getRandomTweet());
            }
            drops[i].draw(g2);
        }

        try {
            Thread.sleep(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        repaint();
    }

}
