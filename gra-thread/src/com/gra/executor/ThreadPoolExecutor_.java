package com.gra.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 工程名:gra-all
 * 包名:com.gra.executor
 * 文件名:ThreadPoolExecutor_
 * description:
 *
 * @author yuh
 * @version V1.0: ThreadPoolExecutor_.java 2020/1/8 17:26 $$
 **/
public class ThreadPoolExecutor_ {
    public static void main(String[] args) {
        // 1.可缓存的线程池 重复利用
        /**
         * 总结: 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程
         */
        /**
         *  CPU密集型时，任务可以少配置线程数，大概和机器的cpu核数相当，这样可以使得每个线程都在执行任务
            IO密集型时，大部分线程都阻塞，故需要多配置线程数，2*cpu核数
            操作系统之名称解释：
            某些进程花费了绝大多数时间在计算上，而其他则在等待I/O上花费了大多是时间，
            前者称为计算密集型（CPU密集型）computer-bound，后者称为I/O密集型，I/O-bound。

         总结：cpu密集为cpu高速切换，故减少线程数量 达到线程数和cpu核数相同时，可减少切换，对某个线程提高的效率
               io密集则是对数据库需要等待响应，在等待过程中，cpu处于休面，即提高线程数来达到cpu的利用率
         */
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            int temp = i;
//            newCachedThreadPool.execute(new Runnable() {
//
//                @Override
//                public void run() {
//                    System.out.println("threadName:" + Thread.currentThread().getName() + ",i:" + temp);
//                }
//            });
//        }

        // 2.可固定长度线程池
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            int temp = i;
//
//            newFixedThreadPool.execute(new Runnable() {
//
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + ",i:" + temp);
//                }
//            });
//        }

        //3. 可定时线程池
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
//		for (int i = 0; i < 10; i++) {
//			int temp = i;
//
//			newScheduledThreadPool.schedule(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println(Thread.currentThread().getName() + ",i:" + temp);
//				}
//			},3, TimeUnit.SECONDS);
//		}


        //4.单线程
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
//        for (int i = 0; i < 10; i++) {
//            int temp=i;
//
//            newSingleThreadScheduledExecutor.execute(new Runnable(){
//
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(500);
//                    } catch (Exception e) {
//                        // TODO: handle exception
//                    }
//
//                    try {
//                        int j =1/0;
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + ",i:" + temp);
//
//                }
//            });;
//        }
//
//        newSingleThreadScheduledExecutor.shutdown();
        //线程如果发生异常但是未被捕捉，将停止运行
        new Thread(new Runnable() {


            @Override
            public void run() {
                while (true) {
                    try {


                        int j = 1 / 0;
                    } catch (Exception e) {

                    }
                }
            }
        }).start();
    }

}
