package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 面试题38_字符串的排列 {
    public String[] permutation(String s) {
        List<String> strings = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return (String[]) strings.toArray();
        }
        if(s.length()==1){
            return new String[]{s};
        }
        int a = 0;
        while (a < s.length()) {
            String[] ss = permutation(s.substring(0, a) + s.substring(a + 1));
            for (String s1 : ss) {
                strings.add(s.charAt(a) + s1);
            }
            a++;
        }

        String[] strings1 = new String[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            strings1[i] = strings.get(i);
        }

        return strings1;
    }
}
