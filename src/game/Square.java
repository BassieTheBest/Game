package game;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends GameObject {
	
	public Square() {}
	
	public Square(int x, int y, double speed, int size, Color color) {
		super(x,y,speed,size,color);
	}
	
	public void update() {
		if(this.y<605-size) {
			this.y += this.speed;
		}
		if (this.x <= 0) {
			this.x = 900;
			this.speed += .2;
		}
		else {
			this.x -= this.speed;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillRect(x, y, size, size);
	}

}
