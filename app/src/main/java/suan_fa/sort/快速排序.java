package suan_fa.sort;

/**
 * Created by hao.li on 2019/10/28.
 */

public class 快速排序 {
    private static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int j = partition(array, start, end);
        sort(array, start, j - 1);
        sort(array, j + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int base = arr[start];

        while (start < end) {
            while (start < end && base <= arr[end]) {
                end--;
            }
            arr[start] = arr[end];

            while (start < end && base >= arr[start]) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = base;

        return start;
    }
}
