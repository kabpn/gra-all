package com.gra.stat;

/**
 * @author w15309
 * @date Created in 2018/10/27 14:33
 * @since
 */
public class HelloServiceConfiguration {

    private String name;

    private String hobby;

    public String getName() {
        return "name is " + name;
    }

    public String getHobby() {
        return "hobby is " + hobby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
