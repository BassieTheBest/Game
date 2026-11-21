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
	 int x;
	 int y;
	 int speed;
	 Color color;
	 int keyCode;
	 BufferedImage image;
	
	
	public ChutePlayer() {
		this.x = 375;
		this.y = 200;
		this.speed = 2;
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
		if (this.x < 0-75) {
			System.out.println("FD");
			this.x = 798;
		}
		if (this.x > 750+75) {
			System.out.println("lk");
			this.x = -48;
		}
		
	}
	
	public void render(Graphics g) {
		g.drawImage(image, x, y, 75, 75, color, null);
	}
	
	public void loadImage() {
		File imageFile = new File("Images/Player.png");
		try {
			this.image = ImageIO.read(imageFile);
		} catch (IOException e) {
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

