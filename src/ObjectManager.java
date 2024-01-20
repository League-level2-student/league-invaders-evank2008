import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship rocket;
ArrayList<Projectile> projectsList = new ArrayList<>();
ArrayList<Alien> aliens = new ArrayList<>();
Random ran = new Random();
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
}
void purgeObjects() {
	for(int i = aliens.size()-1;i>-1;i--) {
		aliens.get(i).update();
	}
}
}
