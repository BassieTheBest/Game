package game;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject {
	public double x;
	public double y;
	public double speed;
	public double width;
	public double height;
	public Color color;
	
	public GameObject() {}
	
	public GameObject(double x, double y, double speed, double width, double height, Color color) {
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

