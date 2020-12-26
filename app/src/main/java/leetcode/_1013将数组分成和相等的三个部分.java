package leetcode;

public class _1013将数组分成和相等的三个部分 {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length <= 0) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        if (sum % 3 != 0) {
            return false;
        }

        int temp = sum / 3;
        int sum0 = 0;
        int n = 0;
        for (int i = 0; i < A.length; i++) {
            sum0 += A[i];
            if (sum0 == temp) {
                sum0 = 0;
                n++;
            }
        }
        // 处理特殊情况，只有temp等于0的情况下才有可能
        if (temp == 0) {
            return n >= 3;
        }
        return n == 3;
    }
}
