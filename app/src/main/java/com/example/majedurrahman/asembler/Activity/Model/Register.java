package com.example.majedurrahman.asembler.Activity.Model;

/**
 * Created by Majedur Rahman on 7/10/2017.
 */

public class Register {

    private  String name;
    private  String value;


    public Register(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
