package jianzhi.day1;

/**
 * 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个 非递减排序 的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * <p>
 * 1,2,3,4,5,.:递增排列
 * 9,8,7,6,5.:递减排列
 * 1,2,3,3,4,5,8,8,.:非递减排列
 * 9,8,7,7,6,5,5,2,1,.:非递增排列
 * <p>
 * 复杂的为 n 的，要想办法改为 logn，一般使用二分法
 */

public class _05旋转数组的最小数字 {

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;

        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] < array[end]) {
                end = middle;
            } else if (array[middle] > array[end]) {
                start = middle;
            } else {
                end = middle;
            }

            if (start + 1 == end || start == end) {
                min = Math.min(array[start], array[end]);
                break;
            }

        }

        return min;
    }
}

