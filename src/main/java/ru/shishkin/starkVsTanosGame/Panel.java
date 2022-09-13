package ru.shishkin.starkVsTanosGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

public class Panel extends JPanel{
	private int x = 10;
	private int y = 10;
	private int napravlenie = 4;
	private int schet = 0;
	private int speed = 1;
	private Image tanos;

	private int x2 = 1100;
	private int y2 = 10;
	private int napravlenie2 = 4;
	private int schet2 = 0;
	private int speed2 = 1;
	private Image stark;
	private Image fon;
	private Image infinity_perchatka;

	private Random rnd = new Random();

	private int xoval = 200 + rnd.nextInt(800);
	private int yoval = 200 + rnd.nextInt(300);

	private int win = 0;
	private Timer timer;

	private class myKey implements KeyListener {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}

		public void keyPressed(KeyEvent e) {
			int keynumber = e.getKeyCode();
			System.out.println(keynumber);

			if (keynumber==87) {
				napravlenie = 1; 
			}
			if (keynumber==69) {
				napravlenie = 2;
			}
			if (keynumber==68) {
				napravlenie = 3;
			}
			if (keynumber==67) {
				napravlenie = 4;
			}
			if (keynumber==88) {
				napravlenie = 5;
			}
			if (keynumber==90) {
				napravlenie = 6;
			}
			if (keynumber==65) {
				napravlenie = 7;
			}
			if (keynumber==81) {
				napravlenie = 8;
			}
			//----------------------------------------------------------------------------------------------------------
			if (keynumber==104) {
				napravlenie2 = 1; 
			}
			if (keynumber==105) {
				napravlenie2 = 2;
			}
			if (keynumber==102) {
				napravlenie2 = 3;
			}
			if (keynumber==99) {
				napravlenie2 = 4;
			}
			if (keynumber==98) {
				napravlenie2 = 5;
			}
			if (keynumber==97) {
				napravlenie2 = 6;
			}
			if (keynumber==100) {
				napravlenie2 = 7;
			}
			if (keynumber==103) {
				napravlenie2 = 8;
			}
			//----------------------------------------------------------------------------------------------------------
			if (schet + schet2>50) {
				if (keynumber==27) {
					System.exit(0);
				}
			}
		} 
	}

	public Panel() {
		addKeyListener(new myKey());
		setFocusable(true);

		timer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x>1080) {
					if (napravlenie == 3) napravlenie=7;
					if (napravlenie == 2) napravlenie=8;
					if (napravlenie == 4) napravlenie=6;
				}
				if (x<0) {
					if (napravlenie == 7) napravlenie=3;
					if (napravlenie == 8) napravlenie=2;
					if (napravlenie == 6) napravlenie=4;
				}
				if(y>460) {
					if (napravlenie == 5) napravlenie=1;
					if (napravlenie == 6) napravlenie=8;
					if (napravlenie == 4) napravlenie=2;
				}
				if (y<0) {
					if (napravlenie == 1) napravlenie=5;
					if (napravlenie == 8) napravlenie=6;
					if (napravlenie == 2) napravlenie=4;
				}
				if (napravlenie == 1) {
					y=y-speed;
				}
				if (napravlenie == 2) {
					x=x+speed;
					y=y-speed;
				}
				if (napravlenie == 3) {
					x=x+speed;
				}
				if (napravlenie == 4) {
					x=x+speed;
					y=y+speed;
				}
				if (napravlenie == 5) {
					y=y+speed;
				}
				if (napravlenie == 6) {
					x=x-speed;
					y=y+speed;
				}
				if (napravlenie == 7) {
					x=x-speed;
				}
				if (napravlenie == 8) {
					x=x-speed;
					y=y-speed;
				}
				//------------------------------------------------------------------------------------------------------
				if(x2>1080) {
					if (napravlenie2 == 3) napravlenie2 = 7;
					if (napravlenie2 == 2) napravlenie2 = 8;
					if (napravlenie2 == 4) napravlenie2 = 6;
				}
				if (x2<0) {
					if (napravlenie2 == 7) napravlenie2=3;
					if (napravlenie2 == 8) napravlenie2=2;
					if (napravlenie2 == 6) napravlenie2=4;
				}
				if(y2>460) {
					if (napravlenie2 == 5) napravlenie2=1;
					if (napravlenie2 == 6) napravlenie2=8;
					if (napravlenie2 == 4) napravlenie2=2;
				}
				if (y2<0) {
					if (napravlenie2 == 1) napravlenie2=5;
					if (napravlenie2 == 8) napravlenie2=6;
					if (napravlenie2 == 2) napravlenie2=4;
				}
				if (napravlenie2 == 1) {
					y2=y2-speed2;
				}
				if (napravlenie2 == 2) {
					x2=x2+speed2;
					y2=y2-speed2;
				}
				if (napravlenie2 == 3) {
					x2=x2+speed2;
				}
				if (napravlenie2 == 4) {
					x2=x2+speed2;
					y2=y2+speed2;
				}
				if (napravlenie2 == 5) {
					y2=y2+speed2;
				}
				if (napravlenie2 == 6) {
					x2=x2-speed2;
					y2=y2+speed2;
				}
				if (napravlenie2 == 7) {
					x2=x2-speed2;
				}
				if (napravlenie2 == 8) {
					x2=x2-speed2;
					y2=y2-speed2;
				}
				//-----------------------------------------------------------------------------------------------------------
				repaint();	
			}});

		timer.start();
		
		try {
			tanos = ImageIO.read(getClass().getClassLoader().getResource("1.png"));
			stark = ImageIO.read(getClass().getClassLoader().getResource("2.png"));
			fon = ImageIO.read(getClass().getClassLoader().getResource("3.jpg"));
			infinity_perchatka = ImageIO.read(getClass().getClassLoader().getResource("4.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(fon, 0, 0, 1200, 700, null);

		proverka();

		g.setColor(Color.GREEN);
		g.fillOval(xoval, yoval, 25, 25); 
		g.drawImage(infinity_perchatka, xoval, yoval, 25, 25, null);
		
		Font font = new Font("Verdana", Font.BOLD, 16);
		g.setFont(font);

		g.setColor(Color.RED);
		g.drawString("TANOS: " + schet, 1020, 15);
		g.drawString("STARK: " + schet2, 1020, 35);
		g.drawString("ESC - EXIT ", 10, 15);

		// g.setColor(Color.RED);
		// g.fillRect(x, y, 100, 200); 
		g.drawImage(tanos, x, y, 100, 200, null);
			
		// g.setColor(Color.BLUE);
		// g.fillOval(x2, y2, 100, 200);
		g.drawImage(stark, x2, y2, 100, 200, null);

		if (win == 2) {
			g.drawString("LOSER!", x2 + 20, y2 + 75);
			g.drawString("WIN!", x + 20, y + 75);
		}
		if (win == 1) {
			g.drawString("LOSER!", x + 20, y + 75);
			g.drawString("WIN!", x2 + 20, y2 + 75);
		}
	}

	private void proverka() {
		if(x - 25 < xoval && xoval < x + 100 && y - 25 < yoval && yoval < y + 200) {
			speed = speed + 1;
			schet = schet + 1;

			xoval = 200 + rnd.nextInt(800);
			yoval = 200 + rnd.nextInt(300);	
		}

		if(x2 - 25 < xoval && xoval < x2 + 100 && y2 - 25 < yoval && yoval < y2 + 200) {
			speed2 = speed2+1;
			schet2 = schet2 + 1;

			xoval = 200 + rnd.nextInt(800);
			yoval = 200 + rnd.nextInt(300);	
		}
		if (schet + schet2 > 50) {
			timer.stop();
			
			if(schet>schet2) {
				win = 2;
			}
			else {
				win = 1;
			}
		}
	}
}
