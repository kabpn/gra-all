package com.gra.service;

/**
 * 工程名:gra-all
 * 包名:com.gra.service
 * 文件名:SmsService
 * description:
 *
 * @author yuh
 * @version V1.0: SmsService.java 2019/12/19 17:19 $$
 **/
public class SmsService {

    public SmsService(){
        System.out.println("调用无参数构造函数..........");
    }
    public void sendMsg(){
        System.out.println(Thread.currentThread().getName()+"：异步形式开始发送短信");
    }
}
