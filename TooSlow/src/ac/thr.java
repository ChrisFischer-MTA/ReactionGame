package ac;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class thr extends Thread{
	static BufferedImage capture;
	static Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	Robot Sonny;
	public void run(){
		
		try {
			Sonny = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {
			
			try {
				capture = new Robot().createScreenCapture(screenRect);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(capture.getRGB(462, 502));
			for (int i = 0; i < capture.getHeight(); i++) {
				for (int j = 0; j < capture.getWidth(); j++){
					if (capture.getRGB(j, i) == -12599004) {
						Sonny.mouseMove(j, i);
						Sonny.mousePress(InputEvent.BUTTON1_DOWN_MASK);
						Sonny.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
						i = capture.getHeight()+100;
						break;
						
					}
					if(capture.getRGB(j, i) == -474430){
						Sonny.mouseMove(j, i);
						Sonny.mousePress(InputEvent.BUTTON1_DOWN_MASK);
						Sonny.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
						i = capture.getHeight()+100;
						break;
					}}
			}

			// ImageIO.write(capture, "bmp", new File(args[0]));
		}
	}
}
