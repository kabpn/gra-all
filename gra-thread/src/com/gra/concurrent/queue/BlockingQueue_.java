package com.gra.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 工程名:gra-all
 * 包名:com.gra.concurrent.queue
 * 文件名:BlockingQueue_
 * description:
 *
 * @author yuh
 * @version V1.0: BlockingQueue_.java 2020/1/8 10:59 $$
 **/
public class BlockingQueue_ {
    public static void main(String[] args) throws InterruptedException {
        //可以阻塞的队列 有界
        BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        //add为普通添加方法超过会报错 offer没超过界限会添加，超过不会添加自行判断，有返回true or false
        arrayBlockingQueue.add("张三");
        arrayBlockingQueue.offer("李四");
        arrayBlockingQueue.offer("王武");
        arrayBlockingQueue.offer("王武2");

//        arrayBlockingQueue.add("王武2");
        boolean offer = arrayBlockingQueue.offer("王麻衣子", 2, TimeUnit.SECONDS);
        System.out.println(arrayBlockingQueue.size()+"---"+offer);
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
    }
}

