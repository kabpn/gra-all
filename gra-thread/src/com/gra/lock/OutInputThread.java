package com.gra.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 工程名:gra-all
 * 包名:com.gra.communicate
 * 文件名:OutInputThread
 * description:
 *
 * @author yuh
 * @version V1.0: OutInputThread.java 2020/1/2 9:55 $$
 **/

class Res {
    Lock lock = new ReentrantLock();
    public String userSex;
    public String userName;
    public boolean flag = false;
}

class InputThread extends Thread {
    private Res res;

    private Condition condition;

    public InputThread(Res res, Condition condition) {
        this.res = res;
        this.condition = condition;
    }

    @Override
    public void run() {

        int count = 0;
        while (true) {
            try {

                res.lock.lock();


                if (res.flag) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (count == 0) {
                    res.userName = "余胜军";
                    res.userSex = "男";
                } else {
                    res.userName = "小紅";
                    res.userSex = "女";
                }
                //设为读
                res.flag = true;
                count = (count + 1) % 2;
                condition.signal();
            } finally {
                res.lock.unlock();

            }

        }
    }


}

class OutThread extends Thread {
    private Res res;
    private Condition condition;

    public OutThread(Res res, Condition condition) {
        this.res = res;
        this.condition = condition;
    }

    @Override
    public void run() {

        while (true) {
            try {

                res.lock.lock();


                if (!res.flag) {

                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //设为写
                res.flag = false;
                condition.signal();
                System.out.println(res.userName + "--" + res.userSex);

            } finally {
                res.lock.unlock();
            }
        }
    }
}

public class OutInputThread {

    public static void main(String[] args) {
        Res res = new Res();
        Condition condition = res.lock.newCondition();
        InputThread intThrad = new InputThread(res,condition);
        OutThread outThread = new OutThread(res,condition);

        intThrad.start();
        outThread.start();

    }

}
