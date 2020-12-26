package jianzhi.day7;

import java.util.ArrayList;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class 字符串的排列 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> strings = new ArrayList<>();
        if (str == null || str.length() <= 0) {
            return strings;
        }

        if (str.length() == 1) {
            strings.add(str);
            return strings;
        }

        char[] chars = str.toCharArray();
        char[] aaachars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            boolean b = false;
            for (int j = 0; j < aaachars.length; j++) {
                if (aaachars[j] == chars[i]) {
                    b = true;
                    break;
                }
            }
            if (b) {
                continue;
            }
            aaachars[i] = chars[i];

            ArrayList<String> string = Permutation(getString(str, i));

            for (int j = 0; j < string.size(); j++) {
                strings.add(chars[i] + string.get(j));
            }
        }
        return strings;
    }

    String getString(String str, int i) {
        if (i >= str.length()) {
            return "";
        }

        String s1 = "";
        if (i + 1 <= str.length()) {
            s1 = str.substring(0, i);
        }

        String s2 = "";
        if (i + 2 <= str.length()) {
            s2 = str.substring(i + 1);
        }

        return s1 + s2;
    }
}
