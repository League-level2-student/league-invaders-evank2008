import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	int count = 0;
	final static int MENU = 0;
	static final int GAME = 1;
	static final int END = 2;
	static int currentState = MENU;
	Font titleFont = new Font("Comic Sans MS", Font.PLAIN, 48);
	Font scaryFont = new Font("Dialog", Font.BOLD, 39);
	Font descriptionFont = new Font("Impact", Font.ITALIC, 32);
	Timer frameDraw;
	Timer alienSpawn;
	Timer shootDelay = new Timer(1000/2,this);
	Rocketship rocket = new Rocketship(250,700,150,120, this);
	ObjectManager man = new ObjectManager(rocket);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	boolean firing = false;
	boolean readyToFire = true;
	boolean songPlaying = true;
	static AudioClip themesong = JApplet.newAudioClip(GamePanel.class.getResource("themesong.wav"));
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
		if (needImage) {
		    loadImage ("bg.png");
		}
		themesong.loop();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==shootDelay) {
			readyToFire=true;
			shootDelay.stop();
		}
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
		man.update();
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
		if (gotImage) {
			g.drawImage(image, 0, 0, 500, 800, null);
		} else {
		g.setColor(Color.black);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		g.setColor(Color.white);
		g.drawString("gameplay", 60, 200);
		man.draw(g);
		if(firing) {
			shoot();
		}
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
		    	reset();
		        currentState = MENU;
		    } else {    
		        if(currentState==MENU) {
		        	startGame();
		        }
		        if(currentState==GAME) {
		        	alienSpawn.stop();
		        }
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
		if (e.getKeyCode()==KeyEvent.VK_SPACE) { 
			firing=true;
			}
		if(e.getKeyCode()==KeyEvent.VK_M) {
			if(songPlaying) {
				themesong.stop();
				songPlaying=false;
			} else {
				themesong.loop();
				songPlaying=true;
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
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			firing=false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
	void startGame() {
		alienSpawn = new Timer(1000*2, man);
		alienSpawn.start();
		
	}
	void shoot() {
		if(readyToFire) {
			man.addProjectile(rocket.getProjectile());	
			readyToFire = false;
			shootDelay.start();
			}
			else {
			//play a gun jammed sound? idk	
			}
	}
	void playSound(String soundFile) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(soundFile));
		sound.play();
	}
	void reset() {
		for(Alien a:man.aliens) {
			a.IsActive=false;
		}
		for(Projectile p:man.projectsList) {
			p.IsActive=false;
		}
		rocket.image=rocket.leEg;
		themesong.loop();
	}
	 
	
}
