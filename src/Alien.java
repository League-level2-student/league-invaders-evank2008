import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject
{
	
	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=1;
		if (needImage) {
		    loadImage ("vadre.png");
		}
	}
void update() {
	y+=speed;
}
void draw(Graphics g) {
	if (gotImage) {
    	g.drawImage(image, x, y, width, height, null);
	} else {
    g.setColor(new Color(20,20,20));
    g.fillRect(x, y, width, height);
	}
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
