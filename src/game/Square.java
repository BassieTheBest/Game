package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Square extends GameObject {
	private Random random = new Random();
	
	public Square() {}
	
	public Square(double x, double y, double speed, double width, double height, Color color) {
		super(x, y, speed, width, height, color);
	}
	
	public void update() {
		if(this.y<605-height) {
			this.y += this.speed;
		}
		if (this.x <= 0) {
			this.x = 900;
			this.width = random.nextInt(30, 60);
			this.height = random.nextInt(40, 80);
		}
		else {
			this.x -= this.speed;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

}
