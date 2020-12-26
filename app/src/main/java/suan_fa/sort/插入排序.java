package suan_fa.sort;

/**
 * Created by hao.li on 2019/10/28.
 */

public class 插入排序 {

    private void sort(int[] array) {
//        重写插入
// 从第二个开始，依次与前边的元素比较，如果比前面的小，则往前交换，直至前面的元素比当前元素小
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int index = i;

            while (index >= 1 && array[index] < array[index - 1]) {
                exChange(array, index, index - 1);
                index--;
            }
        }
    }

    private void exChange(int[] array, int index1, int index2) {
        int a = array[index1];
        array[index1] = array[index2];
        array[index2] = a;
    }
}
