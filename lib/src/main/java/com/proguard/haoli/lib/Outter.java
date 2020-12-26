package com.proguard.haoli.lib;

public class Outter {
private static int ab = 10;
    private String get(){
        return Inner.abc;
    }

    class Inner {
        private static final String abc = "";

        public Inner() {
           int a = ab;
        }
    }
}
