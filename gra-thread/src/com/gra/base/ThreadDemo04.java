
package com.gra.base;

/***
 *
 * @classDesc: 功能描述:(使用常用的线程apidemo)
 * @author: 余胜军
 * @createTime: 2017年12月2日 下午10:32:57
 * @version: v1.0
 * @copyright:蚂蚁课堂(每特学院)上海每特教育科技有限公司出品
 * @website:www.itmayiedu.com或者www.meiteedu.com
 * @weixin:官方微信号 每特学院
 * @QQ:644064779 QQ群:116295598
 */
class CreateThread05 implements Runnable {

    // getId() 线程的id 唯一， 不会重复。
    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }


            //	System.out.println("线程id:" + getId() + ":子线程 ,i:" + i + "name:" + getName());
            System.out.println("线程id:" + Thread.currentThread().getId() + ":子线程 ,i:" + i + "name:" +Thread.currentThread().getName());
            if(i==5){
                Thread.currentThread().stop();// 不安全。不建议大家使用。
            }

        }

    }
}

public class ThreadDemo04 {

    public static void main(String[] args) {
        // 获取主线程的id
        // 任何一个程序肯定有一个主线程
		System.out.println("主线程:" + Thread.currentThread().getId() + ",name:" + Thread.currentThread().getName());
//		CreateThread05 t1 = new CreateThread05();
//		t1.start();
        // for (int i = 0; i < 3; i++) {
        //
        // }
        //	Thread.currentThread()获取到当前线程的
        CreateThread05 t1 = new CreateThread05();
        Thread thread = new Thread(t1,"子线程");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }


                    //	System.out.println("线程id:" + getId() + ":子线程 ,i:" + i + "name:" + getName());
                    System.out.println("线程id:" + Thread.currentThread().getId() + ":子线程 ,i:" + i + "name:" +Thread.currentThread().getName());


                }
            }
        });
        thread.start();
        thread2.start();

    }

}
