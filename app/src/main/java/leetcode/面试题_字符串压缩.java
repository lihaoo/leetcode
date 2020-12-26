package leetcode;

public class 面试题_字符串压缩 {
    public String compressString(String S) {
        if (S.length() <= 1) {
            return S;
        }

        char[] chars = S.toCharArray();
        char[] newChars = new char[chars.length];

        int len = 0;
        int index = 0;
        char currentChar = 0;

        newChars[index] = chars[currentChar];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == currentChar) {
                len++;
            } else {
                newChars[index] = (char) (len + '0');
                index++;
                if (index == chars.length) {
                    return S;
                }
                currentChar = chars[i];
                len = 1;
                newChars[index] = currentChar;
                index++;
                if (index == chars.length) {
                    return S;
                }
            }
        }
        newChars[index] = (char) (len + '0');
        return String.valueOf(newChars);
    }
}
