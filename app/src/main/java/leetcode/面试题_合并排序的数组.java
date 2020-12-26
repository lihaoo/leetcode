package leetcode;

public class 面试题_合并排序的数组 {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] a = new int[m];
        for (int i = 0; i < a.length; i++) {
            a[i] = A[i];
        }
        int i = 0, j = 0;
        int index = 0;
        while (i < a.length && j < B.length) {
            if (a[i] < B[j]) {
                A[index++] = a[i++];
            } else if (a[i] > B[j]) {
                A[index++] = B[j++];
            } else {
                A[index++] = a[i++];
                A[index++] = B[j++];
            }
        }

        while (i < a.length) {
            A[index++] = a[i++];
        }

        while (j < B.length) {
            A[index++] = B[j++];
        }
    }

    // 从后往前排，即可不在申请额外空间
    public void merge2(int[] A, int m, int[] B, int n) {
        int i = 1;
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[A.length - i] = A[m - 1];
                m--;
            } else {
                A[A.length - i] = B[n - 1];
                n--;
            }
            i++;
        }

        while (m > 0) {
            A[A.length - i] = A[m - 1];
            m--;
            i++;
        }

        while (n > 0) {
            A[A.length - i] = B[n - 1];
            n--;
            i++;
        }
    }
}
