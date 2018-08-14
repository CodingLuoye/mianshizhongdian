package com.self.wangba;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class snakeGame extends JPanel {
	private static final long serialVersionUID = 1L;
	// 常量，表示地图的宽和高
	protected static final int HEIGHT = 30;
	protected static final int WIDTH = 30;
	protected static final int CELL_H = 20;
	protected static final int CELL_W = 20;

	protected static final int UP_DIRECTION = 1;
	protected static final int DOWN_DIRECTION = -1;
	protected static final int LEFT_DIRECTION = 2;
	protected static final int RIGHT_DIRECTION = -2;

	private int currentdirection = RIGHT_DIRECTION;

	protected char[][] map = new char[HEIGHT][WIDTH];
	private LinkedList<Point> snake = new LinkedList<Point>();
	private Point food = new Point();

	protected static boolean GameOver = false;
	protected static boolean IsAuto = true;
	private static int Difficult_Degree = 1;
	private Scanner in;

	public snakeGame(int Difficult_Degree){
		snakeGame.Difficult_Degree = Difficult_Degree;
	}
	
	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (map[i][j] == '*') {
					g.setColor(Color.GRAY);
				} else {
					g.setColor(Color.WHITE);
				}
				g.fill3DRect(j * CELL_W, i * CELL_H, CELL_W, CELL_H, true);
			}

			int W = snake.getFirst().x;
			int H = snake.getFirst().y;
			g.setColor(Color.RED);
			g.fill3DRect(W * CELL_W, H * CELL_H, 20, 20, true);

			for (int t = 1; t < this.snake.size(); t++) {
				W = snake.get(t).x;
				H = snake.get(t).y;
				g.setColor(Color.GREEN);
				g.fill3DRect(W * CELL_W, H * CELL_H, 20, 20, true);
			}

			map[food.y][food.x] = '@';
			g.setColor(Color.BLUE);
			g.fill3DRect(food.x * CELL_W, food.y * CELL_H, 20, 20, true);
			
			if(snake.size()==20){
				snakeGame.GameOver = true;
			}

			if (snakeGame.GameOver) {
				g.setColor(Color.ORANGE);
				g.setFont(new Font("宋体", Font.BOLD, 30));
				if(snake.size()==20){
					g.drawString("You Win!", CELL_W * (WIDTH / 2), CELL_H * (HEIGHT / 2));
				}else{
					g.drawString("GAME OVER!", CELL_W * (WIDTH / 2), CELL_H * (HEIGHT / 2));
				}
			}
		}
	}

	public void initMap() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (i == 0 || (i == HEIGHT - 1) || j==0 ||( j == WIDTH - 1)) {
					map[i][j] = '*';
				} else {
					this.map[i][j] = ' ';
				}
			}
		}
	}

	public void initSnake() {
		int x = WIDTH / 2;
		int y = HEIGHT / 2;
		snake.addFirst(new Point(x - 1, y));
		snake.addFirst(new Point(x, y));
		snake.addFirst(new Point(x + 1, y));
	}

	public void initFood() {
		while (true) {
			Random random = new Random();
			int x = random.nextInt(WIDTH - 1);
			int y = random.nextInt(HEIGHT - 1);
			if (map[y][x] != '*' && map[y][x] != '#' && map[y][x] != '$') {
				food.x = x;
				food.y = y;
				break;
			}
		}
	}

	public void runAuto() throws InterruptedException {
		while (true) {
			move();
			IsOver();
			reFresh();
			repaint();
			if (GameOver) {
				repaint();
			}
			Thread.sleep(1000 / Difficult_Degree);
		}
	}

	public void move() {
		Point snakeHead = snake.getFirst();
		switch (currentdirection) {
			case UP_DIRECTION:
				if (!GameOver) {
					snake.addFirst(new Point(snakeHead.x, snakeHead.y - 1));
				}
				break;
			case DOWN_DIRECTION:
				if (!GameOver) {
					snake.addFirst(new Point(snakeHead.x, snakeHead.y + 1));
				}
				break;
			case LEFT_DIRECTION:
				if (!GameOver) {
					if (snakeHead.x == 0) {
						snake.addFirst(new Point(snakeHead.x - 1 + WIDTH, snakeHead.y));
					} else {
						snake.addFirst(new Point(snakeHead.x - 1, snakeHead.y));
					}
				}
				break;
			case RIGHT_DIRECTION:
				if (!GameOver) {
					snake.addFirst(new Point((snakeHead.x + 1) % WIDTH, snakeHead.y));
				}
				break;
			default:
				break;
		}
		if (eatFood()) {
			repaint();
			initFood();
		} else {
			if (!GameOver) {
				snake.removeLast();
			}
		}
	}

	public void changeDirection(int newDirection) {
		if (newDirection + currentdirection != 0) {
			currentdirection = newDirection;
		}
	}

	public boolean eatFood() {
		Point snakehead = snake.getFirst();
		if (snakehead.equals(food)) {
			return true;
		}
		return false;
	}

	public void reFresh() {
		initMap();
		showSnake();
		showFood();
	}

	public boolean showSnake() {
		{
			int W = snake.getFirst().x;
			int H = snake.getFirst().y;
			map[H][W] = '$';
			for (int i = 1; i < this.snake.size(); i++) {
				W = snake.get(i).x;
				H = snake.get(i).y;
				map[H][W] = '#';
			}
			return true;
		}
	}

	public boolean showFood() {
		{
			map[food.y][food.x] = '@';
			return true;
		}
	}

	public void set_Difficuty() {
		System.out.println("请输入难度系数（1——10）");
		in = new Scanner(System.in);
		Difficult_Degree = in.nextInt();
	}

	public void IsOver() {
		// 取蛇头
		Point snakehead = snake.getFirst();
		// 撞墙死
		if (map[snakehead.y][snakehead.x] == '*') {
			GameOver = true;
		}
		// 咬到自己死
		if (map[snakehead.y][snakehead.x] == '#') {
			GameOver = true;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		snakeGame snakeGameOne = new snakeGame(10);
		JFrame frame1 = new JFrame("贪吃蛇变态版");
		JMenuBar menuBar = new JMenuBar();
		frame1.setJMenuBar(menuBar);
		JMenu menuFile = new JMenu("功能");
        menuFile.setMnemonic('F'); 
        menuBar.add(menuFile);
        JMenuItem itemOpen1 = new JMenuItem("暂定");
        itemOpen1.setMnemonic('P');
        itemOpen1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snakeGame.GameOver = true;
			}
		});
        JMenuItem itemOpen2 = new JMenuItem("重试");
        itemOpen2.setMnemonic('R'); 
        itemOpen2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        
        menuFile.add(itemOpen1);
        menuFile.addSeparator();
        menuFile.add(itemOpen2);
        
		
		frame1.setSize(CELL_W * WIDTH + 20, CELL_H * HEIGHT + 45);
		frame1.setVisible(true);
		frame1.add(snakeGameOne);
		snakeGameOne.initMap();
		snakeGameOne.initSnake();
		snakeGameOne.initFood();
		snakeGameOne.repaint();
		frame1.addWindowListener(new WindowListener(){

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		frame1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					IsAuto = false;
					snakeGameOne.changeDirection(UP_DIRECTION);
					break;
				case KeyEvent.VK_DOWN:
					IsAuto = false;
					snakeGameOne.changeDirection(DOWN_DIRECTION);
					break;
				case KeyEvent.VK_RIGHT:
					IsAuto = false;
					snakeGameOne.changeDirection(RIGHT_DIRECTION);
					break;
				case KeyEvent.VK_LEFT:
					IsAuto = false;
					snakeGameOne.changeDirection(LEFT_DIRECTION);
					break;
				default:
					break;
				}
				snakeGameOne.move();
				snakeGameOne.IsOver();
				snakeGameOne.reFresh();
				snakeGameOne.repaint();
				if (snakeGame.GameOver) {
					snakeGameOne.repaint();
				}
				IsAuto = false;
			}
		});
		if (IsAuto) {
			snakeGameOne.runAuto();
		}

	}

}
