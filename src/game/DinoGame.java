package game;

import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Graphics;
	import java.awt.Toolkit;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	
public class DinoGame extends JPanel implements Runnable{


	private static final long serialVersionUID = 1544878978114485164L;
	public JFrame window;
	public Dimension dim;
	public boolean running;
	public Thread gameLoop;
	public Player player;
	public Square[] enemies = new Square[2];
	public Square square2;
	public int index;
	public int counter;
	public double score = 0;
	
    
	
	public DinoGame() {}
	
	public DinoGame(String title, int width, int height) {
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
		this.setBackground(Color.black);
		this.player = new Player();
		this.enemies[0] = new Square(800, 605-50, 1, 50, 50,Color.green);
		this.enemies[1] = new Square(1200, 605-50, 1, 50, 50, Color.green);
		this.addKeyListener(this.player);
		this.window.setVisible(true);
		this.requestFocusInWindow();
		this.start();
		System.out.println("Hekki Moto");
	}
	
	public void update() {
		
		for (index = 0; index < 2; index++) {
			if ((player.y+player.size >= enemies[index].y && player.y <= enemies[index].y+enemies[index].height) && (player.x+player.size >= enemies[index].x && player.x <= enemies[index].x+enemies[index].width)) {
				player.speed = 0;
				enemies[index].speed = 0;
			}
			else {
				enemies[index].update();
				player.update();
				
			}
			
		}
		if (player.speed == 0) {
			for (index = 0; index < 2; index++) {
				enemies[index].speed = 0;
			}
		}
		else {
			int placeholder = 1;
			score+=.1;
			if ((int)(score)/150 == placeholder) {
				for(index=0; index < 2; index++) {
					enemies[index].speed += .02;
					
				}
				placeholder++;
			}
		}
		
	}
	
	public void render(Graphics g) {
		for (index = 0; index < 2; index++) {
			enemies[index].render(g);
		}
		player.render(g);
		g.setColor(Color.white);
		g.setFont(g.getFont().deriveFont(24f));
		g.drawString("Score: "+(int) score, 300, 300);
		
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
				// TODO Auto-generated catch block
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
		DinoGame game = new DinoGame("Game 2026",800,640);
		
	}
	
}
