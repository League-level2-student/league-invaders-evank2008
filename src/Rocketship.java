import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject { 
	int movement = 5;
		boolean hasBeenHit = false;
	public Rocketship(int x,int y,int width,int height) {
		super(x, y, width, height);
		speed=4;
		if (needImage) {
		    loadImage ("le eg.png");
		}
	}
	
	void draw(Graphics g) {
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
        move();
	}
	public void move() {
		switch(movement) {
		case 1:
			x-=speed;
	        if(x<-150) {
	        	x=500;
	        }
	        y-=speed;
	        if(y<-120) {
	        	y=800;
	        }
	    break;
		case 2:
			 y-=speed;
		        if(y<-120) {
		        	y=800;
		        }
	    break;
		case 3:
			y-=speed;
		        if(y<-120) {
		        	y=800;
		        }
	        x+=speed;
	        if(x>500) {
	        	x=-150;
	        }       
	    break;
		case 4:
			x-=speed;
	        if(x<-150) {
	        	x=500;
	        }
	    break;
		case 5:
			
	    break;
		case 6:
			x+=speed;
	        if(x>500) {
	        	x=-150;
	        }       
	    break;
		case 7:
			x-=speed;
	        if(x<-150) {
	        	x=500;
	        }
	        y+=speed;
	        if(y>800) {
	        	y=-120;
	        }
	    break;
		case 8:
			y+=speed;
	        if(y>800) {
	        	y=-120;
	        }
	    break;
		case 9:
			x+=speed;
	        if(x>500) {
	        	x=-150;
	        }       
	        y+=speed;
	        if(y>800) {
	        	y=-120;
	        }
	    break;
	        
		}
	}
	public void right() {
        x+=speed;
        if(x>500) {
        	x=-50;
        }
    }
	public void left() {
        x-=speed;
        if(x<-50) {
        	x=500;
        }
    }
	public void up() {
        y-=speed;
    }
	public void down() {
        y+=speed;
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
	 public Projectile getProjectile() {
	        return new Projectile(x+width/2, y, 60, 60);
	} 
	 public void hurt() {
		 if(hasBeenHit==false) {
			 hasBeenHit = true;
		 }
		 if(hasBeenHit = true) {
			 lose();
		 }
	 }
	 public void lose() {
		 //add code
	 }
}
