package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BoneObs extends GameObject{
	private Random random = new Random();

	public BoneObs() {}
	
	public BoneObs(double x, double y, double speed, double width, double height, Color color) {
		super(x, y, speed, width, height, color);
	}
	
	public void update() {
		if (this.y+this.height <= 0) {
			this.y = 620;
		}
		this.y -= this.speed;
	}
	
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

}
