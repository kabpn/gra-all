package com.gra.threadLocal;

class Res {
    // 生成序列号共享变量
    public static Integer count = 0;
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {

            return 0;
        }

        ;

    };

    public Integer getNum() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }
}

class ThreadLocaDemo2 extends Thread {
    private Res res;

    public ThreadLocaDemo2(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + "i---" + i + "--num:" + res.getNum());
        }

    }

    public static void main(String[] args) {
        Res res = new Res();
        //每个线程有自己的局部变量
        ThreadLocaDemo2 threadLocaDemo1 = new ThreadLocaDemo2(res);
        ThreadLocaDemo2 threadLocaDemo2 = new ThreadLocaDemo2(res);
        ThreadLocaDemo2 threadLocaDemo3 = new ThreadLocaDemo2(res);
        threadLocaDemo1.start();
        threadLocaDemo2.start();
        threadLocaDemo3.start();
    }

}




