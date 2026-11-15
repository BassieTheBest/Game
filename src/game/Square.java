package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Square extends GameObject implements KeyListener{
	int keyCode;
	int jump;
	
	public Square() {}
	
	public Square(int x, int y, int speed, int size, Color color) {
		super(x,y,speed,size,color);
	}
	
	public void update() {
		int xSpeed = this.speed;
		int ySpeed = this.speed;
		if(this.y<605-size && (this.keyCode != 38 && this.keyCode != 32)) {
			this.y += ySpeed;
		}
		if (this.keyCode == 38 || this.keyCode == 32) {
			this.y -= ySpeed;
		}
		
		if (this.x <= 0) {
			this.x = 900;
		}
		else {
			this.x -= xSpeed;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillRect(x, y, size, size);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		this.keyCode = e.getKeyCode();
		
	}

	@Override
	public void keyReleased(KeyEvent a) {
		this.keyCode = 0;
		this.jump = 0;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}
}
