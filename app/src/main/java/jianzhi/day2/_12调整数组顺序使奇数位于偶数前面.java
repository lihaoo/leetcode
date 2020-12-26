package jianzhi.day2;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * <p>
 *     没啥？？？
 * </p>
 */

public class _12调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int[] newArrayOdd = new int[array.length];
        int[] newArrayEven = new int[array.length];
        int indexOdd = 0;
        int indexEven = 0;
        for (int i = 0; i < array.length; i++) {
            if (isOdd(array[i])) {
                newArrayOdd[indexOdd++] = array[i];
            } else {
                newArrayEven[indexEven++] = array[i];
            }
        }

        for (int i = 0; i < indexOdd; i++) {
            array[i] = newArrayOdd[i];
        }

        for (int i = indexOdd; i < indexEven + indexOdd; i++) {
            array[i] = newArrayEven[i - indexOdd];
        }

    }

    // 是否是奇数
    private boolean isOdd(int num) {
        return (num & 1) == 1;
    }

}
