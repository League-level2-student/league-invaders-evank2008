import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.imageio.ImageIO;

public class Projectile extends GameObject{
Random ran = new Random();
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=10;
		if (needImage) {
			switch(ran.nextInt(5)) {
			case 0:
				loadImage ("bullet.png");
				break;
			case 1:
				loadImage ("tomato.png");
				break;
			case 2:
				loadImage ("syringe.png");
				break;
			case 3:
				loadImage ("nokia.png");
				break;
			case 4:
				loadImage ("face.png");
				break;
			}
		    
		}
	}
	void update() {
		y-=speed;
	}
	void draw(Graphics g) {
	    g.setColor(new Color(237,137,83));
	    g.fillRect(x, y, width, height);
	    //bullet
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
