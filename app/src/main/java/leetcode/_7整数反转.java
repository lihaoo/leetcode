package leetcode;

public class _7整数反转 {

    public static void main(String[] strings){
        reverse(1);
    }
    public static int reverse(int x) {
        int a = 0;
        while (x > 0) {
            a = (a + x % 10);
            if (x >= 10) {
                a *= 10;
            }
            x /= 10;
        }
        return a;
    }
}
