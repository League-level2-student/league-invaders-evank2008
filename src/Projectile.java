import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JApplet;

public class Projectile extends GameObject{
Random ran = new Random();
public static BufferedImage bullet;
public static BufferedImage tomato;
public static BufferedImage metalpipefalling;
public static BufferedImage nokia;
public static BufferedImage face;

static {
	bullet = loadImage("bullet.png");
	tomato = loadImage("tomato.png");
	metalpipefalling = loadImage("metalpipefalling.jpg");
	nokia = loadImage("nokia.png");
	face = loadImage("face.png");
	
}
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=5;
			switch(ran.nextInt(5)) {
			case 0:
				image = bullet;
				playSound("sniper_shoot.wav");
				break;
			case 1:
				image = tomato;
				playSound("tomato.wav");
				break;
			case 2:
				image = metalpipefalling;
				playSound("metalpipefallingsoundeffect.mp3");
				break;
			case 3:
				image = nokia;
				playSound("nokia.mp3");
				break;
			case 4:
				image = face;
				playSound("skylarwhiteyo.mp3");
				break;
			}
			
	}
	void update() {
		y-=speed;
	}
	void draw(Graphics g) {
		
        	g.drawImage(image, x, y, width, height, null);
		
	    //bullet
		
	}
	 static BufferedImage loadImage(String imageFile){
	   
	            try {
					return ImageIO.read(Projectile.class.getResourceAsStream(imageFile));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					return null;
				}
	       
	    }
	
	void playSound(String soundFile) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(soundFile));
		sound.play();
	}
	
}

