package com.gra.service;

/**
 * 工程名:gra-all
 * 包名:com.gra.service
 * 文件名:FunctionaMeberlInterface
 * description:
 *
 * @author yuh
 * @version V1.0: FunctionaMeberlInterface.java 2019/12/19 15:45 $$
 **/
@FunctionalInterface
public interface FunctionaMeberlInterface {
    /**
     * 如何在我们的接口中只有一个唯一的抽象方法，该接口中就可以默认的称作为函数接口
     * 函数接口中支持default 和 static 关键修饰我们的方法 允许存在Object类中的方法
     */
    public void addUser(String userName,String passWord);


    public boolean equals(Object obj);
    public String toString();
    /**
     * jdk1.8 重要注解 @FunctionalInterface 约定我们的接口中只能有一个唯一的抽象方法
     */
    default void defaultUser() {

        System.out.println("default");
    }

    static void staticUser() {
        System.out.println("static");
    }

    /**
     * 常用的函数接口有哪些
     * 多线程：Runnable也是一个函数接口 只有一个run抽象方法
     * java排序类 Comparator接口
     */

}
