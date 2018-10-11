package com.example.greendemo.litepal;

import org.litepal.crud.LitePalSupport;

/**
 * Created by yuejz on 2018/10/11
 **/
public class LitePalPerson extends LitePalSupport{

    private String name;

    private int age;

    public LitePalPerson() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
