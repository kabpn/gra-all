package com.gra.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * 工程名:gra-all
 * 包名:com.gra.concurrent
 * 文件名:CyclicBarrier_
 * description:
 *
 * @author yuh
 * @version V1.0: CyclicBarrier_.java 2020/1/7 16:59 $$
 **/


/**
 * CyclicBarrier初始化时规定一个数目，然后计算调用了CyclicBarrier.await()进入等待的线程数。
 * 当线程数达到了这个数目时，所有进入等待状态的线程被唤醒并继续。 
  CyclicBarrier就象它名字的意思一样，可看成是个障碍， 所有的线程必须到齐后才能一起通过这个障碍。 
 CyclicBarrier初始时还可带一个Runnable的参数， 此Runnable任务在CyclicBarrier的数目达到后，所有其它线程被唤醒前被执行。
 */
class Writer extends Thread {
    CyclicBarrier cyclicBarrier;

    public Writer(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始写入数据...");
        try {
            // 模拟耗时时间
            Thread.sleep(30);

            // 执行并行执行成功
            System.out.println(Thread.currentThread().getName() + "写入数据成功...");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + "所以数据执行完毕...");
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}

public class CyclicBarrier_ {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            new Writer(cyclicBarrier).start();
        }
    }

}

