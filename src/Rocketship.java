import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject { 
	int movement = 5;
	public Rocketship(int x,int y,int width,int height) {
		super(x, y, width, height);
		speed=4;
	}
	
	void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
        move();
	}
	public void move() {
		switch(movement) {
		case 1:
			x-=speed;
	        if(x<-50) {
	        	x=500;
	        }
	        y-=speed;
	        if(y<-50) {
	        	y=800;
	        }
	    break;
		case 2:
			 y-=speed;
		        if(y<-50) {
		        	y=800;
		        }
	    break;
		case 3:
			y-=speed;
		        if(y<-50) {
		        	y=800;
		        }
	        x+=speed;
	        if(x>500) {
	        	x=-50;
	        }       
	    break;
		case 4:
			x-=speed;
	        if(x<-50) {
	        	x=500;
	        }
	    break;
		case 5:
			
	    break;
		case 6:
			x+=speed;
	        if(x>500) {
	        	x=-50;
	        }       
	    break;
		case 7:
			x-=speed;
	        if(x<-50) {
	        	x=500;
	        }
	        y+=speed;
	        if(y>800) {
	        	y=-50;
	        }
	    break;
		case 8:
			y+=speed;
	        if(y>800) {
	        	y=-50;
	        }
	    break;
		case 9:
			x+=speed;
	        if(x>500) {
	        	x=-50;
	        }       
	        y+=speed;
	        if(y>800) {
	        	y=-50;
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
}
