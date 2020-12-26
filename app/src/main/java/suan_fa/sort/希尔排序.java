package suan_fa.sort;

/**
 * Created by hao.li on 2019/10/28.
 */

public class 希尔排序 {

    private void sort(int[] array, int lo, int hi) {
// 插入排序的进阶
        // 插入排序每次只能换一个距离，通过分组让元素跨越多个距离
        if (array == null || array.length == 0) {
            return;
        }

        int length = array.length;
        int grep = length / 3;
        while (grep > 0) {
            for (int i = grep; i < length; i++) {
                int index = i;
                while (index - grep >= 0 && array[index] < array[index - grep]) {
                    exChange(array, index, index - grep);
                    index--;
                }
            }
            grep /= 3;
        }
    }

    private void exChange(int[] array, int index1, int index2) {
        int a = array[index1];
        array[index1] = array[index2];
        array[index2] = a;
    }

}

