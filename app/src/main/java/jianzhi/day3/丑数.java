package jianzhi.day3;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }
        int uglyNum[] = new int[index];
        uglyNum[0] = 1;

        int a = 1;

        int a2 = 0;
        int a3 = 0;
        int a5 = 0;

        while (a < index) {
            int min = Math.min(uglyNum[a2] * 2, uglyNum[a3] * 3);
            min = Math.min(min, uglyNum[a5] * 5);
            uglyNum[a] = min;

            while (uglyNum[a2] * 2 <= min) {
                a2++;
            }
            while (uglyNum[a3] * 3 <= min) {
                a3++;
            }
            while (uglyNum[a5] * 5 <= min) {
                a5++;
            }

            a++;
        }

        return uglyNum[--a];
    }
}
