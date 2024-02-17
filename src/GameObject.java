import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JApplet;

public class GameObject {
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	Rectangle collisionHull;
	 int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0;
	 boolean IsActive = true;
	 public GameObject(int x,int y,int width,int height) {
		 this.x=x;
		 this.y=y;
		 this.width=width;
		 this.height=height;
		 collisionHull = new Rectangle(x,y,width,height);
	 }
	 
	 void update() {
		 collisionHull.setBounds(x, y, width, height); 
		 
	 }
	 void playSound(String soundFile) {
			AudioClip sound = JApplet.newAudioClip(getClass().getResource(soundFile));
			sound.play();
		}
}
