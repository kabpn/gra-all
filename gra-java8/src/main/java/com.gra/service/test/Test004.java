package com.gra.service.test;

import com.gra.service.SmsService;

/**
 * 工程名:gra-all
 * 包名:com.gra.service.test
 * 文件名:Test004
 * description:
 *
 * @author yuh
 * @version V1.0: Test004.java 2019/12/19 17:17 $$
 **/
public class Test004 {

    public static void main(String[] args){
        //方法引用：在Lambda再做了一层简化
            new Thread(()->{
                new SmsService().sendMsg();
            }).start();

        /**
         *使用我们的方法引用调用我们方法
         *调用我们的实例方法
         *
         */
        SmsService smsService = new SmsService();
        //左边  抽象方法 调用类的实例:: 右边就是我们具体实例的方法
        new Thread(smsService::sendMsg).start(); //方法引用
        Runnable runnable = smsService::sendMsg;

        /**
         * 用掉我们构造函数 类名::new
         */
        new Thread(SmsService::new).start();

        /**
         * ()->{
         *
         *      //方法主体代码 new SmsService().sendMsg()
         *     } ==等同于我们的Runnable接口
         */
    }
}
