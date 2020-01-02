package com.gra.volatile_;


/**
 * 什么是Volatile
 * Volatile 关键字的作用是变量在多个线程之间可见。
 */
class ThreadVolatileDemo extends Thread {
	public   boolean flag = true;



	@Override
	public void run() {
		System.out.println("子线程开始执行...");
		while (flag) {

//			System.out.println("--");
		}
		System.out.println("子线程执行结束...");
	}
	public void setFlag(boolean flag){
		this.flag=flag;
	}

}

public class ThreadVolatile {
	public static void main(String[] args) throws InterruptedException {
              ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();
              threadVolatileDemo.start();
//              threadVolatileDemo.setFlag(false);
              Thread.sleep(3000);
              //主线程修改共享全局变量为false
              threadVolatileDemo.setFlag(false);
              System.out.println("flag已结修改false!");
              Thread.sleep(1000);
              System.out.println(threadVolatileDemo.flag);
	}
}
