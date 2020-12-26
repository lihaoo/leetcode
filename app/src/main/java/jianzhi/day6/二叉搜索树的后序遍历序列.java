package jianzhi.day6;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class 二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null) {
            return false;
        }

        if (sequence.length == 1 || sequence.length == 2) {
            return true;
        }

        int end = sequence.length - 1;
        int start = 0;
        while (start < end && sequence[start] < sequence[end]) {
            start++;
        }

        for (int i = start; i < sequence.length - 1; i++) {
            if (sequence[i] < sequence[sequence.length - 1]) {
                return false;
            }
        }

        return VerifySquenceOfBST(getLeft(sequence, start)) && VerifySquenceOfBST(getRight(sequence, start));
    }

    public int[] getLeft(int[] sequence, int length) {
        if (length <= 0) {
            return new int[1];
        }
        int[] ints = new int[length];

        for (int i = 0; i < length; i++) {
            ints[i] = sequence[i];
        }

        return ints;
    }

    public int[] getRight(int[] sequence, int start) {
        if (sequence.length - start - 1 <= 0) {
            return new int[1];
        }

        int[] ints = new int[sequence.length - start - 1];

        for (int i = 0; i < sequence.length - start - 1; i++) {
            ints[i] = sequence[start + i];
        }

        return ints;
    }
}
