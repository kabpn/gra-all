package com.gra.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 工程名:gra-all
 * 包名:com.gra.concurrent
 * 文件名:ConcurrentHashMap_
 * description:
 *
 * @author yuh
 * @version V1.0: ConcurrentHashMap_.java 2020/1/7 15:51 $$
 **/


public class ConcurrentHashMap_ {
    ConcurrentMap concurrentMap = new ConcurrentHashMap<String,Object>();
    /**
     * ConcurrentHashMap
        ConcurrentMap接口下有俩个重要的实现 :
        ConcurrentHashMap
        ConcurrentskipListMap (支持并发排序功能。弥补ConcurrentHas hMa p)
        ConcurrentHashMap内部使用段(Segment)来表示这些不同的部分，每个段其实就是一个
        小的HashTable,它们有自己的锁。只要多个修改操作发生在不同的段上，它们就可以并
        发进行。把一个整体分成了16个段(Segment.也就是最高支持16个线程的并发修改操作。
        这也是在重线程场景时减小锁的粒度从而降低锁竞争的一种方案。并且代码中大多共享变
        量使用volatile关键字声明，目的是第一时间获取修改的内容，性能非常好
     */
}
