package jianzhi.day7;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int a = array[0];
        int count = 1;
        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            if (a == array[i]) {
                count++;
            } else {
                count--;

                if (count == 0) {
                    a = array[i];
                    num = a;
                    count = 1;
                }
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                count++;
            }
        }

        return count * 2 > array.length ? num : 0;
    }
}
