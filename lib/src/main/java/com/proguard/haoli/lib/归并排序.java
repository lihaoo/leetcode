package com.proguard.haoli.lib;

public class 归并排序 {
    public static void main(String[] args) {
        int[] array = new int[]{ 9, 1, 8, 0, 7, 11, 6, 2, 4, 1, 5 };
        sort(array);
    }

    private static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }



        for (int i = 0; i < array.length; i++) {
            System.out.print("  " + array[i]);
        }
    }

    private static void logArray(int[] objects) {
        for (int i = 0; i < objects.length; i++) {
            System.out.print("  " + objects[i]);
        }
        System.out.println();
    }

    private static void exChange(int[] array, int index1, int index2) {
        int a = array[index1];
        array[index1] = array[index2];
        array[index2] = a;
    }

}