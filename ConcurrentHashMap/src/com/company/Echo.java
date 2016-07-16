package com.company;

/**
 * Created by Jae on 7/6/2016.
 */
public class Echo {

    private String name;
    public Echo(String name) {
        this.name = name;
    }
    public void echo() {
        System.out.println("echo:" + name);
    }
}
