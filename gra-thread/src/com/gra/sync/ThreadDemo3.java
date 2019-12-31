package com.gra.sync;

/**
 * 线程1：先拿到oj锁，再this锁，再oj锁
 * 线程2：先this锁，再oj锁
 * 原因：线程1想要得到的this锁还没在线程2中释放，等等造成锁占用，卡死
 * 死锁的产生：同步中嵌套同步，互相不释放
 * 线程三大性：可见性（java内存模型理解可见问题）、一致性、有序性  数据可见才能实现一致  是否
 *
 */
class ThreadTrain3 implements Runnable {
	// 总共有一百张火车 当一变量被static修饰的话存放在永久区，当class文件被加载的时候就会被初始化。
	private static int train1Count = 1000;
	private Object oj = new Object();
	public boolean flag = true;

	@Override
	public void run() {
		// 为了能够模拟程序一直在抢票的话。 where
		if (flag) {
			// 执行同步代码块this锁
			while (true) {
				synchronized (oj) {
					sale();
				}
			}
		} else {
			// 同步函数
			while (true) {

				// 出售火車票
				sale();
			}
		}

	}

	public synchronized void sale() {

		// 同步代码块 synchronized 包裹需要线程安全的问题。
		synchronized (oj) {
			if (train1Count > 0) {
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(Thread.currentThread().getName() + ",出售第" + (1000 - train1Count + 1) + "票");
				train1Count--;
			}
		}

	}
}

public class ThreadDemo3 {

	public static void main(String[] args) throws InterruptedException {
		ThreadTrain3 threadTrain3 = new ThreadTrain3();
		Thread t1 = new Thread(threadTrain3, "窗口①");
		Thread t2 = new Thread(threadTrain3, "窗口②");
		t1.start();
		Thread.sleep(40);
		threadTrain3.flag = false;
		t2.start();
	}

}
