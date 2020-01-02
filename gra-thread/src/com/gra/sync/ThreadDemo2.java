package com.gra.sync;

class ThreadTrain2 implements Runnable {
    // 总共有一百张火车 当一变量被static修饰的话存放在永久区，当class文件被加载的时候就会被初始化。
    private  static int train1Count = 100;
    private Object oj = new Object();
    public boolean flag = true;

    @Override
    public void run() {
        // 为了能够模拟程序一直在抢票的话。 where
        if (flag) {
            //执行同步代码块this锁
            while (train1Count > 0) {

                synchronized (oj) {
                    if (train1Count > 0) {
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        System.out.println("--------------------1");
                        System.out.println("----------------------" + flag);
                        System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - train1Count + 1) + "票");
                        train1Count--;
                    }
                }

            }
        } else {
            // 同步函数
            while (train1Count > 0) {

                // 出售火車票
                sale();
            }
        }

    }

    public synchronized void sale() {

        // 同步代码块 synchronized 包裹需要线程安全的问题。
        // synchronized (oj) {
        if (train1Count > 0) {
            try {
                Thread.sleep(50);

            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("--------------------2");
            System.out.println("----------------------" + flag);
            System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - train1Count + 1) + "票");
            train1Count--;
        }
        // }

    }
}

public class ThreadDemo2 {

    public static void main(String[] args) throws InterruptedException {
        ThreadTrain2 threadTrain2 = new ThreadTrain2();
        Thread t1 = new Thread(threadTrain2, "窗口①");
        Thread t2 = new Thread(threadTrain2, "窗口②");
        t1.start();
        Thread.sleep(60);
        threadTrain2.flag = false;
        t2.start();
    }

}
