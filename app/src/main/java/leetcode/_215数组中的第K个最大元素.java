package leetcode;

public class _215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        k = nums.length - k + 1;
        int[] a = new int[k + 1];

        for (int i = 0; i < k; i++) {
            a[i + 1] = nums[i];
            int temp = i + 1;
            while (temp / 2 != 0 && a[temp] > a[temp / 2]) {
                exchange(a, temp, temp / 2);
                temp /= 2;
            }

            System.out.println(a.toString());
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= a[1]) {
                continue;
            }

            a[1] = nums[i];
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

        return a[1];
    }

    private void exchange(int[] ints, int index1, int index2) {
        int temp = ints[index1];
        ints[index1] = ints[index2];
        ints[index2] = temp;
    }

}
