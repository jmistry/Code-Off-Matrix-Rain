package com.prolificidea.codeoff;

import com.prolificidea.codeoff.image.SimpleImageGenerator;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Matrix Rain");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(Config.SCREEN_SIZE, Config.SCREEN_SIZE);
        frame.setResizable(false);
        SimpleImage simpleImage = SimpleImageGenerator.readImage("twitter.png");
        frame.add(new Rain(simpleImage));
        frame.setVisible(true);
    }

}