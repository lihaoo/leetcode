package com.proguard.haoli.lib.力扣;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _438找到字符串中所有字母异位词 {
    Map<Character, Integer> pMap = new HashMap<>();
    Map<Character, Integer> sMap = new HashMap<>();

    public static void main(String[] args) {
        _438找到字符串中所有字母异位词 a = new _438找到字符串中所有字母异位词();
        a.findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> integers = new ArrayList<>();
        if (s == null || p == null || s.length() <= 0 || p.length() <= 0) {
            return integers;
        }

        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), get(pMap, p.charAt(i)) + 1);
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            sMap.put(s.charAt(right), get(sMap, s.charAt(right)) + 1);
            right++;

            if (right - left > p.length()) {
                sMap.put(s.charAt(left), get(sMap, s.charAt(left)) - 1);
                left++;
            }

            while (right - left == p.length() && check()) {
                integers.add(left);
                sMap.put(s.charAt(left), get(sMap, s.charAt(left)) - 1);
                left++;
            }
        }
        return integers;
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
            if (entry.getValue() - get(sMap, entry.getKey()) != 0) {
                return false;
            }
        }
        return true;
    }

    private int get(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            return map.get(c);
        }
        return 0;
    }
}
