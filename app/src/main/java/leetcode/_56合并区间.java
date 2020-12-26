package leetcode;

public class _56合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        sort(intervals);


        int[][] merge = new int[intervals.length][2];
        int left = 0, right = 0;
        int length = 1;
        for (int i = 0; i < intervals.length; i++) {
            if (right >= intervals[i][0]) {
                right = intervals[i][1];
            } else {
                length++;
                left = intervals[i][0];
                right = intervals[i][1];
            }
            merge[length - 1][0] = left;
            merge[length - 1][1] = right;
        }

        int[][] merge1 = new int[length][2];
        for (int i = 0; i < length; i++) {
            merge1[i][0] = merge[i][0];
            merge1[i][1] = merge[i][1];
        }

        return merge1;
    }

    private void sort(int[][] intervals) {
        sort(intervals, 0, intervals.length - 1);
    }

    private static void sort(int[][] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int j = partition(array, start, end);
        sort(array, start, j - 1);
        sort(array, j + 1, end);
    }

    private static int partition(int[][] arr, int start, int end) {
        int[] base = arr[start];

        while (start < end) {
            while (start < end && base[0] <= arr[end][0]) {
                end--;
            }
            arr[start] = arr[end];

            while (start < end && base[0] >= arr[start][0]) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = base;

        return start;
    }
}
