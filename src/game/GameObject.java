package game;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject {
	public int x;
	public int y;
	public double speed;
	public int width;
	public int height;
	public Color color;
	
	public GameObject() {}
	
	public GameObject(int x, int y, double speed, int width, int height, Color color) {
		this.x=x;
		this.y=y;
		this.speed=speed;
		this.width=width;
		this.height = height;
		this.color=color;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	
}

