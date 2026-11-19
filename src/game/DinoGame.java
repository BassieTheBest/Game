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
	public Square square2;
	
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
		this.square2 = new Square(800, 605-50, 1, 50, Color.green);
		this.addKeyListener(this.player);
		this.window.setVisible(true);
		this.requestFocusInWindow();
		this.start();
		System.out.println("Hekki Moto");
	}
	
	public void update() {
		if ((player.y+player.size >= square2.y && player.y <= square2.y+square2.size) && (player.x+player.size >= square2.x && player.x <= square2.x+square2.size)) {
			player.speed = 0;
			square2.speed = 0;
		}
		if (square2.y+square2.size == 605) {
			
		}
		square2.update();
		player.update();
	}
	
	public void render(Graphics g) {
		player.render(g);
		square2.render(g);
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
