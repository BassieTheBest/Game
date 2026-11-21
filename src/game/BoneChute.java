package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoneChute extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1544878978114485164L;
	public JFrame window;
	public Dimension dim;
	public boolean running;
	public Thread gameLoop;
	public ChutePlayer player;
	public BoneObs plat;
	public BoneObs plat2;
	public int index;
	public int counter;
	public double score = 0;
	
	public BoneChute() {}
	public BoneChute(String title, int width, int height) {
		this.window = new JFrame(title);
		this.dim = new Dimension(width,height);
		
		this.window.setPreferredSize(this.dim);
		this.window.setMinimumSize(dim);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setLocationRelativeTo(null);
		this.window.setResizable(false);
		
		this.setDoubleBuffered(true);
		this.setPreferredSize(dim);
		this.window.add(this);
		this.setBackground(Color.white);
		
		this.player = new ChutePlayer();
		this.addKeyListener(this.player);
		this.plat = new BoneObs(0,50,1,300,20,Color.red);
		this.plat2 = new BoneObs(500,50,1,300,20,Color.red);
		
		this.window.setVisible(true);
		this.requestFocusInWindow();
		this.start();
	}
	
	public void update() {
		if ((player.y+75 >= plat.y && player.y <= plat.y+plat.height) && (player.x+75 >= plat.x && player.x <= plat.x+plat.width) || (player.y+75 >= plat2.y && player.y <= plat2.y+plat2.height) && (player.x+75 >= plat2.x && player.x <= plat2.x+plat2.width)) {
			plat.speed = 0;
			plat2.speed = 0;
			player.speed = 0;
		}
		player.update();
		plat.update();
		plat2.update();
	}
	public void render(Graphics g) {
		player.render(g);
		plat.render(g);
		plat2.render(g);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.render(g);
		g.dispose();
		Toolkit.getDefaultToolkit().sync();
	}
	
	@Override
	public void run() {
		while(running) {
			update();
			repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
	
	public void start() {
		this.running=true;
		this.gameLoop =  new Thread(this);
		this.gameLoop.start();
	}
	
	public static void main(String[] args) {
		BoneChute game = new BoneChute("BoneChute 2026",800,640);
		
	}

}
