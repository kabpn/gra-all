package com.gra.concurrent.queue;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 工程名:gra-all
 * 包名:com.gra.concurrent.queue
 * 文件名:ConcurrentLinkedDeque_
 * description:
 *
 * @author yuh
 * @version V1.0: ConcurrentLinkedDeque_.java 2020/1/8 10:52 $$
 **/
/**
 * 并发队列 concurrentLinkedDeque BlockingQueue
 */
public class ConcurrentLinkedDeque_ {
    public static void main(String[] args){
        // 无界  非阻塞队列
        ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
        concurrentLinkedDeque.offer("张三");
        concurrentLinkedDeque.offer("李四");
//		System.out.println(concurrentLinkedDeque.size());
//		System.out.println(concurrentLinkedDeque.poll());
//		System.out.println(concurrentLinkedDeque.peek());
//		System.out.println(concurrentLinkedDeque.size());
    }
}
