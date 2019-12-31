package com.gra.service.test;

import java.util.ArrayList;

/**
 * 工程名:gra-all
 * 包名:com.gra.service.test
 * 文件名:Test003
 * description:
 *
 * @author yuh
 * @version V1.0: Test003.java 2019/12/19 16:30 $$
 **/
public class Test003 {
    public static void main(String[] args){

        ArrayList<String > strings = new ArrayList<>();
        strings.add("小薇");
        strings.add("小爱");
        strings.add("小可");
        strings.forEach((s)->{
            System.out.println(s);
        });

        strings.forEach(System.out::println);
    }
}
