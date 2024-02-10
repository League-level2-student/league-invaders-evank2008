import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JApplet;

public class ObjectManager implements ActionListener{
Rocketship rocket;
ArrayList<Projectile> projectsList = new ArrayList<>();
ArrayList<Alien> aliens = new ArrayList<>();
Random ran = new Random();
AudioClip bowl = JApplet.newAudioClip(getClass().getResource("bowl.wav"));
AudioClip sound = JApplet.newAudioClip(getClass().getResource("vadredeath.wav"));
AudioClip bowlsniper = JApplet.newAudioClip(getClass().getResource("bowlsniper.wav"));
public ObjectManager(Rocketship rocket) {
	this.rocket=rocket;
}
void addProjectile(Projectile proj) {
	projectsList.add(proj);
}
void addAlien() {
	aliens.add(new Alien(ran.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
void update() {
	for(Alien a:aliens) {
		a.update();
		if(a.y>800) {
			a.IsActive=false;
		}
	}
	for(Projectile a:projectsList) {
		a.update();
		if(a.y>800) {
			a.IsActive=false;
		}
	}
	checkCollision();
	purgeObjects();
}
void purgeObjects() {
	for(int i = aliens.size()-1;i>-1;i--) {
		if(aliens.get(i).IsActive==false) {
			aliens.remove(i);
		}
	}
	for(int i = aliens.size()-1;i>-1;i--) {
		if(aliens.get(i).IsActive==false) {
			aliens.remove(i);
		}
	}
	for(int i = projectsList.size()-1;i>-1;i--) {
		if(projectsList.get(i).IsActive==false) {
			projectsList.remove(i);
		}
	}
}
void draw(Graphics g) {
	rocket.draw(g);
	for(Alien a:aliens) {
		a.draw(g);
	}
	for(Projectile a:projectsList) {
		a.draw(g);
	}
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	addAlien();
}
void checkCollision() {
	for(Alien a:aliens) {
		for(Projectile p:projectsList) {
		if(a.collisionHull.intersects(p.collisionHull)) {
			a.IsActive=false;
			if(p.image==p.nokia) {
				//bowling time
				if(p.hasBowled==false) {
					bowlsniper.play();
					p.hasBowled = true;
				} else {
				bowl.play();
				}
			} else {
				p.IsActive=false;
				
				sound.play();
			}
		}
			
		}
		if(a.collisionHull.intersects(rocket.collisionHull)) {
			rocket.hurt();
			a.IsActive=false;
		}
	}
}

}
