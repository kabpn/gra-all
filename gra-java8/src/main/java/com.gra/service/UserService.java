package com.gra.service;

/**
 * 工程名:gra-all
 * 包名:com.gra.service
 * 文件名:UserService
 * description:
 *
 * @author yuh
 * @version V1.0: UserService.java 2019/12/19 14:27 $$
 **/
public interface UserService {

    public void addUser(); //抽象方法

    /**
     * java1.8之前，接口中不能定义普通方法
     * java1.8开始推出default 在接口中使用default关键字修饰的情况下，就可以使用方法体了
     * java1.8开始推出static  ----------static-----------------------------------
     * 总结：jdk1.8开始使用 static和default 修饰我们的方法 可以写方法体
     */


    /**
     * 子类可以覆盖接口的方法
     *
     */
    default String defaultGetUser() {

        return "gra";
    }

    /**
     * 在我们的借口中使用static修饰的方法不能被子类继承
     */
    static void staticUser() {
        System.out.println("del");
    }

    /**
     * 疑问：为什么jdk1.8开始推出default，static 答案： 面向函数编程
     */
}
