package suan_fa.sort;

/**
 * Created by hao.li on 2019/10/28.
 */

public class 选择排序 {
    private void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];// 假设第当前值为最小的
            int dex = i;//记住当前的下标
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    dex = j;
                }
            }

            exChange(array, i, dex);
        }
    }

    private void exChange(int[] array, int index1, int index2) {
        int a = array[index1];
        array[index1] = array[index2];
        array[index2] = a;
    }
}
