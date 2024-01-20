import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	int count = 0;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont = new Font("Comic Sans MS", Font.PLAIN, 48);
	Font scaryFont = new Font("Dialog", Font.BOLD, 39);
	Font descriptionFont = new Font("Impact", Font.ITALIC, 32);
	Timer frameDraw;
	Rocketship rocket = new Rocketship(250,700,50,50);
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
		//System.out.println("action " + count);
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
		g.setFont(scaryFont);
		g.setColor(Color.black);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.white);
		g.drawString("gameplay", 60, 200);
		rocket.draw(g);
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
		g.drawString("press enter to restart", 43, 430);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//press enter to swap game state
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			if(rocket.movement>3) {
				rocket.movement-=3;
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(rocket.movement<7) {
				rocket.movement+=3;
			}	
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(rocket.movement!=1&&rocket.movement!=4&&rocket.movement!=7) {
				rocket.movement-=1;
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(rocket.movement!=3&&rocket.movement!=6&&rocket.movement!=9) {
				rocket.movement+=1;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			rocket.movement+=3;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			rocket.movement-=3;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			rocket.movement+=1;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			rocket.movement-=1;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
