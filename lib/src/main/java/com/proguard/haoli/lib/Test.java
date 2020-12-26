package com.proguard.haoli.lib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import sun.rmi.runtime.Log;

public class Test<T> {
    static class Food {
    }

    static class Fruit extends Food {
    }

    static class Apple extends Fruit {
    }

    List fruitaaaaa = new ArrayList<>();

    // 把?理解为一个特定的、但是不存在的类，例如这里可以假设?为一个Banana类
    public static void main(String[] args) {
        Test test = new Test();
        test.fruitaaaaa = new ArrayList<>();
        test.get("sssssss");

        try {
            Method method = test.getClass().getMethod("get", Object.class);

            Class aClass = Method.class;
            System.out.println(" =====aClass===== " + aClass.getName());
            for (Method method1 : aClass.getDeclaredMethods()) {
                System.out.println(" =====method1===== " + method1.getName());

                if (method1.getName().equals("getGenericSignature")) {
                    try {
                        method1.setAccessible(true);
                        System.out.println(" =====Signature===== " + method1.invoke(method));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }


//            Method methodddd = Method.class.getMethod("getGenericSignature", null);
//            System.out.println(" ==========" + method.toGenericString());
//
//            try {
//                methodddd.invoke(null);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

//    public List<Fruit> get(T t) {
//        return new ArrayList<>();
//    }

    // get(Ljava/lang/Object;)Ljava/lang/String;
    public String get(T t) {
        return "ssss";
    }

    public void set(String x) {
        System.out.println(x);
    }

//    public T get(T t) {
//        return t;
//    }

}
