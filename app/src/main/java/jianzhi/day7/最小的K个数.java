package jianzhi.day7;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (input == null || input.length < 1 || k <= 0 || input.length < k) {
            return integers;
        }

        for (int i = 0; i < input.length && i < k; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] < input[j + 1]) {
                    ex(input, j, j + 1);
                }
            }
        }
        int end = input.length - 1;
        for (int i = 0; i < k; i++) {
            integers.add(input[end - i]);
        }

        return integers;
    }

    private void ex(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
