package jianzhi.day1;

/**
 * 二维数组中的查找
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 二分查找的写法 判断条件小于等于 首尾下标相加除二
 */

public class _00二维数组中的查找 {

    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }

        int m = array.length;//第几行
        if (m == 0) {
            return false;
        }
        int n = array[0].length;//第几列
        if (n == 0) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            if (rank(target, array[i])) {
                return true;
            }
        }
        return false;

    }

    /**
     * 二分法查找
     *
     * @param target
     * @param array
     * @return
     */
    public boolean rank(int target, int[] array) {
        //头尾赋值
        int start = 0;
        int end = array.length - 1;

        while (start <= end) { //while 的条件是 小于等于
            int mid = (end + start) / 2;//记住这句

            if (target < array[mid]) {
                end = mid - 1;
            }

            if (target > array[mid]) {
                start = mid + 1;
            }

            if (target == array[mid]) {
                return true;
            }
        }

        return false;
    }
}
