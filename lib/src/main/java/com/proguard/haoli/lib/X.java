package com.proguard.haoli.lib;

public class X {

    public static void main(String[] args) {
        X x = new X();
        try {
            throw new IllegalAccessException("error");
        } catch (IllegalAccessException e) {
            int a = 1 / 0;
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }
}
