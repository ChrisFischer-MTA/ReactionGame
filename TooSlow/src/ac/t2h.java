package ac;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class t2h {

	static Thread t = new Thread();

	public static void main(String[] args) throws AWTException, IOException {
		// TODO Auto-generated method stub
		//thr n = new thr();
		//thr a = new thr();
		thr c = new thr();
		//n.start();
		//a.start();
		c.start();
		
	}
}
