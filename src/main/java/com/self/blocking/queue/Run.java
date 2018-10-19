package com.self.blocking.queue;

public class Run {
	private static final int ADD_THREAD_NUM = 3;
	private static final int REMOVE_THREAD_NUM = 300;

	public static void main(String[] args) throws InterruptedException {
		final MyQueue myQueue = new MyQueue();

		for (int i = 0; i < ADD_THREAD_NUM; i++) {
			final int index = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						myQueue.add("" + index);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		for (int i = 0; i < REMOVE_THREAD_NUM; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						myQueue.removeFirst();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}

		Thread.sleep(100);

		System.out.println(myQueue.getSize());
	}

}