package com.nthreads.cursorloader.entity;

/**
 * Package Name : com.nthreads.cursorloader.entity
 * Created by Muhammad Nauman Zubair on 1/27/2016 4:02 PM
 * Copyright (c) 2016 nthreads. All rights reserved.
 */
public class Doctor {
    private int id;
    private String name;
    private int number;

    public Doctor() {
        this.name = "";
        this.number = 0;
    }

    public Doctor(String name, int number) {
        this();
        this.name = name;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
