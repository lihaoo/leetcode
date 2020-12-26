package leetcode;

public class 面试题40最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length < k) {
            return arr;
        }

        if (k == 0) {
            return new int[]{};
        }

        int[] a = new int[k + 1];

        for (int i = 0; i < k; i++) {
            a[i + 1] = arr[i];
            int temp = i + 1;
            while (temp / 2 != 0 && a[temp] > a[temp / 2]) {
                exchange(a, temp, temp / 2);
                temp /= 2;
            }
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] >= a[1]) {
                continue;
            }

            a[1] = arr[i];
            int temp = 1;
            while (temp * 2 < k + 1) {
                if ((temp * 2 + 1) < (k + 1)) {
                    if (a[temp] < (a[temp * 2] > a[temp * 2 + 1] ? a[temp * 2] : a[temp * 2 + 1])) {
                        int tempIndex = a[temp * 2] > a[temp * 2 + 1] ? temp * 2 : (temp * 2 + 1);
                        exchange(a, temp, a[temp * 2] > a[temp * 2 + 1] ? temp * 2 : (temp * 2 + 1));
                        temp = tempIndex;
                    } else {
                        break;
                    }
                } else {
                    if (a[temp] < a[temp * 2]) {
                        int tempIndex = temp * 2;
                        exchange(a, temp, temp * 2);
                        temp = tempIndex;
                    } else {
                        break;
                    }
                }
            }
        }
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = a[i + 1];
        }
        return b;
    }

    private void exchange(int[] ints, int index1, int index2) {
        int temp = ints[index1];
        ints[index1] = ints[index2];
        ints[index2] = temp;
    }
}
