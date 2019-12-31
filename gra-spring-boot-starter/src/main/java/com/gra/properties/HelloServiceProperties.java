package com.gra.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author w15309
 * @date Created in 2018/10/27 14:31
 * @since
 */
@ConfigurationProperties(prefix = "com.wisdom")
public class HelloServiceProperties {

    private String name = "wisdom";

    private String hobby = "basketball";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
