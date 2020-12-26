package leetcode;

/**
 * 辗转相除法求最大公因式
 * 欧几里德算法又称辗转相除法，是指用于计算两个正整数a，b的最大公约数。
 * 原理：两个整数的最大公约数 = 其中较小的数 与 他们的余数 的最大公约数
 * 求最大公因式一般叫gcd
 * 简介：
 * https://zhidao.baidu.com/question/70215985.html
 */
public class _1071字符串的最大公因子 {

    public static void main(String[] strings){

    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1) ) {
            return "";
        }

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
