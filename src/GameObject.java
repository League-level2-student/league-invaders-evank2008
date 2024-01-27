import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
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
	 }
	 
	 void update() {
		 
	 }
	
}
