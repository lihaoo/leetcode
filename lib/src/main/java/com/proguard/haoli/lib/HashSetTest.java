package com.proguard.haoli.lib;

import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSetTest hashSetTest = new HashSetTest();
        hashSetTest.test();
    }

    private void test() {
        HashSet<P> ps = new HashSet<>();
        ps.add(new P());
        ps.add(new P());
        ps.add(new P());

        System.err.println("  " + ps.size());

        System.err.println(3.3d == 3.3d);

    }

    public class P {
        @Override
        public boolean equals(Object o) {
            return true;
        }

        @Override
        public int hashCode() {
            return 3;
        }
    }
}
