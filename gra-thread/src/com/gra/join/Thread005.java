
package com.gra.join;

public class Thread005 {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 60; i++) {
					System.out.println("子线程,i:"+i);
				}
			}
		});
		thread.start();
		// 主线程让子线程先执行完毕的话，怎么做？
		try {
			thread.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 0; i < 30; i++) {
			System.out.println("主线程,i:"+i);
		}
	}

}
