import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	int count = 0;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont = new Font("Comic Sans MS", Font.PLAIN, 48);
	Font scaryFont = new Font("Dialog", Font.BOLD, 39);
	Font descriptionFont = new Font("Impact", Font.ITALIC, 32);
	Timer frameDraw;
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}

	}
	public GamePanel() {
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		count ++;
		System.out.println("action " + count);
		repaint();
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
	}
	
	void updateMenuState() {
		
	}
	void updateGameState() {
		
	}
	void updateEndState() {
		
	}

	void drawMenuState(Graphics g) {
		
		g.setColor(new Color(255,43,209));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("le eg vaders", 200, 200);
		g.setFont(scaryFont);
		g.setColor(Color.white);
		g.drawString(":)",100,250);
		g.setFont(titleFont);
		g.drawString(">",82,252);
		g.setFont(descriptionFont);
		g.drawString("press enter to start", 240, 500);
		g.setColor(Color.yellow);
		g.drawString("top text", 240, 700);
		
	}
	void drawGameState(Graphics g) {
		
	}
	void drawEndState(Graphics g) {
		g.setColor(new Color(120,12,23));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("you got legd by vadre", 43, 200);
		g.setFont(descriptionFont);
		g.setColor(new Color(255,43,209));
		g.drawString("Game Over", 43, 400);
	}
	
}
