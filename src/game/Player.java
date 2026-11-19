package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends GameObject implements KeyListener{
	 int size;
	 int x;
	 int y;
	 int speed;
	 Color color;
	 int keyCode;
	
	
	public Player() {
		this.size = 50;
		this.x = 375;
		this.y = 605-50;
		this.speed = 1;
		this.color = Color.pink;
	}
	
	public void update() {
		if(this.y<605-size && (this.keyCode != 38 && this.keyCode != 32)) {
			this.y += this.speed;
		}
		if (this.keyCode == 38 || this.keyCode == 32) {
			this.y -= this.speed;
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
	public void keyReleased(KeyEvent e) {
		this.keyCode = 0;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {	
	}
}
