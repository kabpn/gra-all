package com.gra.service.test;

import com.gra.service.UserService;
import com.gra.service.impl.UserServiceImpl;

/**
 * 工程名:gra-all
 * 包名:com.gra.service.test
 * 文件名:Test001
 * description:
 *
 * @author yuh
 * @version V1.0: Test001.java 2019/12/19 15:21 $$
 **/
public class Test001 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        String result = userService.defaultGetUser();
        System.out.println("result:"+result);
        UserService.staticUser();
    }
}
