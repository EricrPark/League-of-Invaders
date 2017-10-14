import java.awt.Graphics;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gamePanel;
	public LeagueInvaders() {
		gamePanel = new GamePanel();
		frame = new JFrame();
		int width = 500;
		int length = 800;
		frame.setSize(width, length);
		frame.setVisible(true);
		setup();
	}
	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.add(gamePanel);
		frame.addKeyListener(gamePanel);
		gamePanel.startGame();
	}


	public static void main(String[] args) {
		LeagueInvaders gameFrame = new LeagueInvaders();
	}
}
