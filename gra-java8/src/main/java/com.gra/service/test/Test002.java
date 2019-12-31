package com.gra.service.test;

import com.gra.service.FunctionaMeberlInterface;

/**
 * 工程名:gra-all
 * 包名:com.gra.service.test
 * 文件名:Test002
 * description:
 *
 * @author yuh
 * @version V1.0: Test002.java 2019/12/19 15:29 $$
 **/
public class Test002 {
    public static void main(String[] args) {
        /**
         * 什么函数接口呢？
         * 如何在我们的接口中只有一个唯一的抽象方法，该接口中就可以默认的称作为函数接口
         * 定义的接口是不能被new，如果没有子类的情况下 调用我们接口的方法 匿名内部类形成
         */
        /**
         * jdk1.8之前使用我们的匿名内部类形式调用我们的方法
         */
        FunctionaMeberlInterface functionaMeberlInterface = new FunctionaMeberlInterface() {
            @Override
            public void addUser(String userName, String passWord) {
                System.out.println("userName:" + userName + ",passWord:" + passWord);
            }
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };

        functionaMeberlInterface.addUser("gra","123");
        /**
         * 使用java8新特性lambda 简化我们匿名内部类
         */
        FunctionaMeberlInterface functionaMeberlInterface1 = (userName, passWord) ->{
            System.out.println("userName:" + userName + ",passWord:" + passWord);
        } ;
        functionaMeberlInterface1.addUser("gra","123");
    }
}
