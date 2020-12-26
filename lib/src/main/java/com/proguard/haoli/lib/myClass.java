package com.proguard.haoli.lib;

import java.util.ArrayList;
import java.util.List;

public class myClass {
    public static void main(String[] arg) {
//        int[] b = new int[]{ 2, 7, 4, 5, 10, 1, 9, 3, 8, 6 };
//        int[] b = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//        int[] b = new int[]{ 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//        int[] b = new int[]{ 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//        int[] b = new int[]{ 11, 15, 12, 9, 14 };

//        sort(b);
//
//        System.out.println("排序后的结果：");
//        for (int x : b) {
//            System.out.print(x + " ");
//        }

        List list = new ArrayList();
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);

        System.out.print("==============" + list.size());
    }

    private static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int j = partition(array, start, end);
        sort(array, start, j - 1);
        sort(array, j + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int base = arr[start];

        while (start < end) {

            while (start < end && arr[end] >= base) {
                end--;
            }

            arr[start] = arr[end];

            while (start < end && arr[start] <= base) {
                start++;
            }

            arr[end] = arr[start];
        }

        arr[start] = base;

        return start;
    }

}