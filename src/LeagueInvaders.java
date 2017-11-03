import javax.swing.JFrame;
public class LeagueInvaders {
	JFrame frame;
	GamePanel gamePanel;
	static int width;
	static int length;
	public LeagueInvaders() {
		gamePanel = new GamePanel();
		frame = new JFrame();
		width = 500;
		length = 800;
		frame.setSize(width, length);
		setup();
		frame.setVisible(true);
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
