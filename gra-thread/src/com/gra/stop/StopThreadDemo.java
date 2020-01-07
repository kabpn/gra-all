package com.gra.stop;

class StopThread extends Thread {
	private volatile boolean flag = true;

	@Override
	public synchronized void run() {
		System.out.println("子线程开始....");
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				 e.printStackTrace();
				stopThread();
			}
		}
		System.out.println("子线程结束....");
	}

	public void stopThread() {
		flag = false;
	}

}

public class StopThreadDemo {

	public static void main(String[] args) {
		StopThread stopThread = new StopThread();
		stopThread.start();
		for (int i = 1; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("i:" + i);
				if (i == 8) {
					// stopThread.stopThread();
					stopThread.interrupt();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
