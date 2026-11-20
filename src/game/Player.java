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
	 private int counter = 0;
	 private int index;
	
	
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
		if (this.y == 605-size) {
			this.counter = 0;
		}
		if (this.keyCode == 38 || this.keyCode == 32) {
			for (index = 0; index < 3; index++) {
				if (this.y <= 450) {
					counter = 5;
				}
				else {
					this.y -= this.speed;
				}
				
			}
			
			
		}
	}
	
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillRect(x, y, size, size);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		counter++;
		if (counter > 5) {
			this.keyCode = 0;
		}
		else {
			this.keyCode = e.getKeyCode();
			System.out.println(counter + " " + this.y);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.keyCode = 0;
		this.counter = 6; 
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {	
	}
}
