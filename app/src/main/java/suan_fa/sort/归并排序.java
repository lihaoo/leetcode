package suan_fa.sort;

/**
 * Created by hao.li on 2019/10/28.
 */

public class 归并排序 {

    private static int[] sort(int[] array) {
        int length = array.length;

        if (array.length < 2) {
            return array;
        }

        int[] a = new int[length / 2];
        int[] b = new int[length - length / 2];

        for (int i = 0; i < length; i++) {
            if (i < length / 2) {
                a[i] = array[i];
            } else {
                b[i - length / 2] = array[i];
            }
        }

        a = sort(a);
        b = sort(b);
        return merge(a, b);
    }

    private static int[] merge(int[] a, int[] b) {
        int[] array = new int[a.length + b.length];

        int aIndex = 0, bIndex = 0;
        int i = 0;
        while (i < array.length) {

            if (a[aIndex] <= b[bIndex]) {
                array[i] = a[aIndex];
                aIndex++;
            } else {
                array[i] = b[bIndex];
                bIndex++;
            }

            i++;

            if (aIndex == a.length) {
                for (int j = bIndex; j < b.length; j++) {
                    array[i] = b[j];
                    i++;
                }
                return array;
            }

            if (bIndex == b.length) {
                for (int j = aIndex; j < a.length; j++) {
                    array[i] = a[j];
                    i++;
                }
                return array;
            }
        }

        return array;
    }

    private void exChange(int[] array, int index1, int index2) {
        int a = array[index1];
        array[index1] = array[index2];
        array[index2] = a;
    }
}
