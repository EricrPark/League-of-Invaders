import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	Font titleFont;
	//GameObject gameObject;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager objManager = new ObjectManager(rocket);
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		//gameObject = new GameObject(10, 10, 100, 100);
		timer = new Timer(1000/60, this);
		timer.addActionListener(this);
	}
	public void updateMenuState() {
		
	}
	public void updateGameState() {
		objManager.update();
	}
	public void updateEndState() {
		
	}
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.length);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("League Invaders", 75, 200);
	}
	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.length); 
		objManager.draw(g);
		System.out.println(rocket.x);
	}
	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.length);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 125, 200);
	}	
	void startGame() {
		timer.start();
	}
	public void paintComponent(Graphics g) {
		//gameObject.draw(g);
		if(currentState == MENU_STATE) {
			drawMenuState(g);
		}
		else if(currentState == GAME_STATE) {
			drawGameState(g);
		}
		else if(currentState == END_STATE) {
			drawEndState(g);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(currentState == MENU_STATE) {
			updateMenuState();
		}
		else if(currentState == GAME_STATE) {
			updateGameState();
		}
		else if(currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("test typed");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
		}
		if(currentState > END_STATE){
            currentState = MENU_STATE;
		}
		else if(currentState > GAME_STATE){
            currentState = END_STATE;
		}
		else if(currentState > MENU_STATE){
            currentState = GAME_STATE;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.x = rocket.x+rocket.speed;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.x = rocket.x-rocket.speed;
		}
		if (rocket.x > 450) {
			rocket.x = 450;
		}
		else if (rocket.x < 0) {
			rocket.x = 0;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("test released");
	}
}
