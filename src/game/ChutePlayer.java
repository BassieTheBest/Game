package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ChutePlayer extends GameObject implements KeyListener{
	int size;
	 int x;
	 int y;
	 int speed;
	 Color color;
	 int keyCode;
	 BufferedImage image;
	
	
	public ChutePlayer() {
		this.size = 50;
		this.x = 375;
		this.y = 605-50;
		this.speed = 1;
		this.color = Color.pink;
		loadImage();
	}
	
	public void update() {
		if (this.keyCode == 37) {
			this.x -= this.speed;
		}
		if (this.keyCode == 39) {
			this.x += this.speed;
		}
		if (this.x < 0-this.size) {
			System.out.println("FD");
			this.x = 798;
		}
		if (this.x > 750+this.size) {
			System.out.println("lk");
			this.x = -48;
		}
		
	}
	
	public void render(Graphics g) {
		g.drawImage(this.image,this.x,this.y,null);
	}
	
	public void loadImage() {
		File imageFile = new File("images/ship4.png");
		try {
			this.image = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
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

