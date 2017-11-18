import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {

	ArrayList<Projectile> list;
	Rocketship rocket;

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
		list = new ArrayList<Projectile>();
	}

	public void update() {
		rocket.update();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).update();
		}
	}

	public void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).draw(g);
		}
	}

	public void addProjectile(Projectile p) {
		list.add(p);
	}
}
