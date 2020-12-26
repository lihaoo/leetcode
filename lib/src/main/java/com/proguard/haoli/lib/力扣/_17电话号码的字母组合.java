package com.proguard.haoli.lib.力扣;

import java.util.ArrayList;
import java.util.List;

public class _17电话号码的字母组合 {

    public static void main(String[] args) {
        _17电话号码的字母组合 a = new _17电话号码的字母组合();

        a.letterCombinations("23");
    }

    private List<String> strings = new ArrayList<>();
    private List<Character> characters = new ArrayList<>();
    private String digits;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;

        back();

        return strings;
    }

    private void back() {
        if (characters.size() == digits.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < characters.size(); i++) {
                stringBuilder.append(characters.get(i));
            }
            strings.add(stringBuilder.toString());
            return;
        }

        char[] chars = getChars(digits.charAt(characters.size()) - '0');

        for (int j = 0; j < chars.length; j++) {
            characters.add(chars[j]);
            back();
            characters.remove(characters.size() - 1);
        }
    }

    private char[] getChars(int x) {
        if (x < 2 || x > 9) {
            return new char[]{};
        }

        String s = "";
        switch (x) {
            case 2:
                s = "abc";
                break;
            case 3:
                s = "def";
                break;
            case 4:
                s = "ghi";
                break;
            case 5:
                s = "jkl";
                break;
            case 6:
                s = "mno";
                break;
            case 7:
                s = "pqrs";
                break;
            case 8:
                s = "tuv";
                break;
            case 9:
                s = "wxyz";
                break;
        }

        return s.toCharArray();
    }
}
