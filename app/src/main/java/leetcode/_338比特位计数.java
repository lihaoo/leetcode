package leetcode;

public class _338比特位计数 {
    public int[] countBits(int num) {
        int[] integers = new int[num + 1];

        for (int i = 0; i < num; i++) {
            integers[i] = integers[i >> 1] + (i & 1);
        }

        return integers;
    }
}
