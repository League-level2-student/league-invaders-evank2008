import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel gpanel;

	 
public static void main(String[] args) {
	LeagueInvaders league = new LeagueInvaders();
	league.setup();
}
public LeagueInvaders() {
	frame = new JFrame();
	gpanel = new GamePanel();
}
void setup() {
	frame.add(gpanel);
	frame.addKeyListener(gpanel);
	frame.setVisible(true);
	frame.setSize(WIDTH,HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
