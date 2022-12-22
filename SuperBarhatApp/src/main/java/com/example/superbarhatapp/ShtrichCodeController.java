package com.example.superbarhatapp;

import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class ShtrichCodeController {

    public Canvas canvas;



    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        double mm = Toolkit.getDefaultToolkit().getScreenResolution() / 25.4;

        int[] sticks = new int[]{
                5, 1, 4, 0, 9, 2, 0, 2, 0, 1, 2, 3, 4, 5, 6,
        };


        gc.setFill(Color.BLACK);

        int x0 = 20, y0 = 10;
        double heightSticks = 22.85 * mm;
        double widthSticks = 0.5 * mm;
        double betweenSticks = 0.9 * mm; // ОЧ МАЛО
        int startStick = x0;

        gc.fillRect(startStick, y0, widthSticks, heightSticks + 1.65 * mm);
        startStick += widthSticks + betweenSticks;
        gc.fillRect(startStick, y0, widthSticks, heightSticks + 1.65 * mm);
        startStick += widthSticks + betweenSticks;

        boolean drawSticks = false;
        for (int numSticks = 0; numSticks < sticks.length; numSticks++) {
            double superStick = sticks[numSticks] * 0.15 * mm;
            if (numSticks == sticks.length / 2 && !drawSticks) {
                superStick = widthSticks;
                gc.setFill(Color.BLACK);
                gc.fillRect(startStick, y0, superStick, heightSticks + 1.65 * mm);
                startStick += superStick + betweenSticks;
                gc.fillRect(startStick, y0, superStick, heightSticks + 1.65 * mm);
                startStick += superStick + betweenSticks;
                numSticks--;
                drawSticks = true;
                continue;
            }
            if (superStick == 0) {
                superStick = 1.35 * mm;
                gc.setFill(Color.WHITE);
            } else {
                gc.setFill(Color.BLACK);
            }
            gc.fillRect(startStick, y0, superStick, heightSticks);
            startStick += superStick + betweenSticks;
        }

        gc.fillRect(startStick, y0, widthSticks, heightSticks + 1.65 * mm);
        startStick += widthSticks + betweenSticks;
        gc.fillRect(startStick, y0, widthSticks, heightSticks + 1.65 * mm);
    }
}
