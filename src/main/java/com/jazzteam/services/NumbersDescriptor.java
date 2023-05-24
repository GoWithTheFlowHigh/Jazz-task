package com.jazzteam.services;


public class NumbersDescriptor {
    private String number;

    public NumbersDescriptor(String number) {
        this.number = number;
    }

    public int getMaxNumOrder() {
        return number.length() - 1;
    }

    public int getNamedNumIndex() {
        return getMaxNumOrder() < 3 ? 0 : getMaxNumOrder() / 3;
    }
}
