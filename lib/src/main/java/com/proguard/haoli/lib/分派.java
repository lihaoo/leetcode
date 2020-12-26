package com.proguard.haoli.lib;

public class 分派 {
    public static void main(String[] args) {
        分派 fenpai = new 分派();
        Super aSuper = new Sub();
        fenpai.logName(aSuper);
    }

    private int logName(Super aSuper) {
        return 0;
    }

//    private int logName(Sub aSub) {
//
//    }
}


class Super {
    public String getName() {
        return "父类";
    }
}

class Sub extends Super {
    public String getName() {
        return "子类";
    }
}