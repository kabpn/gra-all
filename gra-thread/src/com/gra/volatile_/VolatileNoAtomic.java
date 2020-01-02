package com.gra.volatile_;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileNoAtomic extends Thread {
    // 需要10个线程同时共享count   static修饰关键字， 存放在静态区， 只会存放一次，所有的线程中都共享，
//	private  volatile static int count = 0;
	/**
	 * AtomicInteger jdk1.5并发包里的
	 * 保证线程原子性，一致性，解决线程安全问题，结果一致
	 * volatile只是当前可见，在多线程执行的情况下不阻塞，写的值也可能发生混乱，不能保证原子性，结果一致
	 * sync同步有阻塞，能保证数据原子性
	 */

	private static AtomicInteger count = new AtomicInteger(0);
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
//			count++;
			count.incrementAndGet();
		}
		//System.out.println(getName()+","+count);
		System.out.println(getName()+","+count.get());
	}
	public static void main(String[] args) {
		 // 创建10个线程
		VolatileNoAtomic[] volatileNoAtomicList=new VolatileNoAtomic[10];
		for (int i = 0; i < volatileNoAtomicList.length; i++) {
			volatileNoAtomicList[i]=new VolatileNoAtomic();
		}
		for (int i = 0; i < volatileNoAtomicList.length; i++) {
			volatileNoAtomicList[i].start();
		}
	}
}
