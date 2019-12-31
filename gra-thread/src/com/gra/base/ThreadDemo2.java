
package com.gra.base;



class CreateThreadDemo02 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println("子线程 run,i:" + i);
		}

	}

}

/**
 *
 * @classDesc: 功能描述:(如何创建多线程)
 * @author: 余胜军
 * @createTime: 2017年12月2日 下午9:51:39
 * @version: v1.0
 * @copyright:蚂蚁课堂(每特学院)上海每特教育科技有限公司出品
 * @website:www.itmayiedu.com或者www.meiteedu.com
 * @weixin:官方微信号 每特学院
 * @QQ:644064779 QQ群:116295598
 */
public class ThreadDemo2 {

	/**
	 * 什么是进程， 进程就是正在运行的应用程序，进程是线程的集合。 什么是线程，线程就是一条执行路径，一个独立的执行单元。 什么是多线程
	 * 为了提高程序效率 创建有哪些方式？ 1、使用继承Therad类方式 继承Thread类重写run方法 2、使用实现runlabe接口方式
	 * 3、使用匿名内部类方式 4、callable 5、使用线程池创建线程。
	 */
	public static void main(String[] args) {
		CreateThreadDemo02 t1 = new CreateThreadDemo02();
		Thread thread = new Thread(t1);
		thread.start();
		for (int i = 0; i < 30; i++) {
			System.out.println("主线程 i:" + i);
		}

	}

}
