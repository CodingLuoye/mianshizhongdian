package com.self.providerconsumer;

/**
 * 按顺序打印A B C
 * @author YCKJ1409
 */
public class PrintDemo {
	//友情提示：线程数不要太多，否则机器死机
	
	private static final int PRINT_A_NUM = 10;
	private static final int PRINT_B_NUM = 33;
	private static final int PRINT_C_NUM = 165;

	public static void main(String[] args) {
		final PrintService printService = new PrintService();

		/* 打印B的线程有PRINT_B_NUM个 */
		for (int i = 0; i < PRINT_B_NUM; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						printService.printB();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		/* 打印A的线程有PRINT_A_NUM个 */
		for (int i = 0; i < PRINT_A_NUM; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						printService.printA();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		/* 打印C的线程有PRINT_C_NUM个 */
		for (int i = 0; i < PRINT_C_NUM; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						printService.printC();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

}