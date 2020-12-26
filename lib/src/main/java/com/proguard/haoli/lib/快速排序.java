package com.proguard.haoli.lib;

public class 快速排序 {

    public static void main(String[] args) {
        int[] array = new int[]{ 13, 9, 1, 8, 0, 7, 11, 6, 2, 4, 1, 5 };
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (array == null || array.length == 0) {
            return;
        }

        if (start > end) {
            return;
        }

        int j = sorts(array, start, end);
        sort(array, start, j - 1);
        sort(array, j + 1, end);

        logArray(array);
    }

    private static int sorts(int[] array, int start, int end) {
        int base = array[start];
        while (start < end) {
            while (start < end && base <= array[end]) {
                end--;
            }
            array[start] = array[end];
            while (start < end && base >= array[start]) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = base;
        return start;
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