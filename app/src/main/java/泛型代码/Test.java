package 泛型代码;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static class Food {
    }

    static class Fruit extends Food {
    }

    static class Apple extends Fruit {
    }

    // 把?理解为一个特定的、但是不存在的类，例如这里可以假设?为一个Banana类
    public static void main(String[] args) {
        List<? extends Fruit> fruits = new ArrayList<>();
        fruits.add(new Food());     // compile error
        fruits.add(new Fruit());    // compile error
        fruits.add(new Apple());    // compile error

        fruits = new ArrayList<Fruit>(); // compile success
        fruits = new ArrayList<Apple>(); // compile success
        fruits = new ArrayList<Food>(); // compile error
        fruits = new ArrayList<? extends Fruit>(); // compile error: 通配符类型无法实例化

        Fruit object = fruits.get(0);    // compile success
    }

    // 同样把?理解为一个不存在的类，例如：植物类，也是Fruit的父类
    public static void main(String[] args) {
        List<? super Fruit> fruits = new ArrayList<>();
        fruits.add(new Food());     // compile error
        fruits.add(new Fruit());    // compile success
        fruits.add(new Apple());    // compile success

        fruits = new ArrayList<Fruit>(); // compile success
        fruits = new ArrayList<Apple>(); // compile error
        fruits = new ArrayList<Food>(); // compile success
        fruits = new ArrayList<? super Fruit>(); // compile error: 通配符类型无法实例化

        Fruit object = fruits.get(0); // compile error
    }


    public static void test2() {
        B<? extends Fruit> b = new B<Apple>();
        b.add(new Apple());
    }

    static class B<T> {
        private void add(T t) {

        }
    }

}
