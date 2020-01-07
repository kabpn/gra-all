package com.gra.communicate;

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
    public String userSex;
    public String userName;
    public boolean flag = false;
}

class InputThread extends Thread {
    private Res res;

    public InputThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {

        int count = 0;
        while (true) {

            synchronized (res) {
                System.out.println("生产者");
                if(res.flag){
                    try {
                        res.wait();
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
//                res.notify();
            }
        }
    }


}

class OutThread extends Thread {
    private Res res;

    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (res) {
//
                System.out.println("消费者");
                if(!res.flag){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //设为写
                res.flag=false;
//                res.notify();
                System.out.println(res.userName + "--" + res.userSex);
            }
        }
    }
}

public class OutInputThread {

    public static void main(String[] args) {
        Res res = new Res();
        InputThread intThrad = new InputThread(res);
        OutThread outThread = new OutThread(res);

        intThrad.start();
        outThread.start();

    }

}
