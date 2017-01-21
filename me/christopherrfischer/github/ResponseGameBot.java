package me.christopherrfischer.github;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class ResponseGameBot {

    final public static int BLUE = -13924399;
    final public static int GREEN = -11805846;

    // Green 
    private static int[] topLeft = {9999, 9999}; // Good!
    private static int[] topRight = {0, 99999};
    private static int[] bottomLeft = {9999, 0};
    private static int[] bottomRight = {0, 0};

    public static void main(String[] arg) throws Exception {
        Thread.sleep(3000);
        Robot t = createRobot();
        getCoords(t);
        Rectangle clickable = new Rectangle(topLeft[0], topLeft[1], topRight[0] - topLeft[0], (bottomRight[1] - topRight[1]));
        BufferedImage e;
        System.out.println((topLeft[0]+" "+topLeft[1]+" "+(topRight[0] - topLeft[0])+" "+(bottomRight[1] - topRight[1])));
        int[] res = new int[2];
        while (true) {
            e = t.createScreenCapture(clickable);
            res = doesExist(e, BLUE);
            if (res[0] != -1) {
                clickMouse(t, res[0]+topLeft[0], res[1]+topRight[1]);
            }
            res = doesExist(e, GREEN);
            if (res[0] != -1) {
                clickMouse(t, res[0]+topLeft[0], res[1]+res[1]+topRight[1]);
            }
        }
    }

    public static Robot createRobot() throws AWTException {
        return new Robot();
    }

    public static void getCoords(Robot w) {
        BufferedImage cap = w.createScreenCapture(new Rectangle(new Dimension(Toolkit.getDefaultToolkit().getScreenSize())));

        int[][] e = new int[cap.getWidth()][cap.getHeight()];

        for (int i = 0; i < cap.getWidth(); i++) {
            for (int j = 0; j < cap.getHeight(); j++) {
                if (cap.getRGB(i, j) == -13924399) {
                    checkCreds(i, j);
                }
                if (i == 634 && j == 144) {
                    System.out.println(cap.getRGB(i, j));
                }
            }
        }

        System.out.println("Top left - " + topLeft[0] + "," + topLeft[1]);
        System.out.println("Top right - " + topRight[0] + "," + topRight[1]);
        System.out.println("Bottom left - " + bottomLeft[0] + "," + bottomLeft[1]);
        System.out.println("Bottom right - " + bottomRight[0] + "," + bottomRight[1]);
    }

    public static void checkCreds(int i, int j) {
        if (i <= topLeft[0] && j <= topLeft[1]) {
            topLeft[0] = i;
            topLeft[1] = j;
        }
        if (i >= topRight[0] && j <= topRight[1]) {
            topRight[0] = i;
            topRight[1] = j;
        }
        if (i <= bottomLeft[0] && j >= bottomLeft[1]) {
            bottomLeft[0] = i;
            bottomLeft[1] = j;
        }
        if (i >= bottomRight[0] && j >= bottomRight[1]) {
            bottomRight[0] = i;
            bottomRight[1] = j;
        }

    }

    public static int[] doesExist(BufferedImage cap, int search) {
        int[] res = new int[2];
        for (int i = 0; i < cap.getWidth(); i++) {
            for (int j = 0; j < cap.getHeight(); j++) {
                if (cap.getRGB(i, j) == search) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        res[0] = -1;
        return res;
    }

    public static void clickMouse(Robot t, int x, int y) throws InterruptedException {
        t.mouseMove(x, y);
        t.mousePress(InputEvent.BUTTON1_MASK);
        t.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep(40);
    }
}
