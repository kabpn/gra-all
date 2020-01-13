package com.gra.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 工程名:gra-all
 * 包名:com.gra.concurrent
 * 文件名:CountDownLatch_
 * description:
 *
 * @author yuh
 * @version V1.0: CountDownLatch_.java 2020/1/7 16:20 $$
 **/

/**
 * CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
 * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 */
public class CountDownLatch_ {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            public void run() {
                System.out.println("我是子线程1开始执行任务......");
                try {
                    //子线程正在处理事情
                    Thread.sleep(10);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                countDownLatch.countDown();//每次减1
                System.out.println("我是子线程1开始结束任务......");
            }
        }).start();;
        new Thread(new Runnable() {
            public void run() {
//                try {
//                    countDownLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("我是子线程2开始执行任务......");
                try {
                    //子线程正在处理事情
                    Thread.sleep(10);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                countDownLatch.countDown();//每次减1
                System.out.println("我是子线程2开始结束任务......");
            }
        }).start();
        System.out.println("主线任务执行前");
        countDownLatch.await();//如果不为0的时候，一直等待
        System.out.println("主线程开始执行任务");
        for (int i = 0; i < 10; i++) {
            System.out.println("main i:"+i);
        }
    }
}
