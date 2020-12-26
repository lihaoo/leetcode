package leetcode;

public class _647回文子串 {

    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int sLength = s.length();

        boolean[][] booleans = new boolean[sLength][sLength];

        int temp = 0;
        for (int length = 1; length <= sLength; length++) {
            for (int start = 0; start + length <= sLength; start++) {
                if (length == 1) {
                    booleans[start][0] = true;
                } else if (length == 2) {
                    booleans[start][1] = charAtS(s, start) == charAtS(s, start + length - 1);
                } else {
                    booleans[start][length - 1] = booleans[start + 1][length - 3] && (charAtS(s, start) == charAtS(s, start + length - 1));
                }

                if (booleans[start][length - 1]) {
                    temp++;
                }
            }
        }
        return temp;
    }

    private Character charAtS(String s, int index) {
        int len = s.length();
        if (index < 0 || index >= len) {
            return null;
        } else {
            return s.charAt(index);
        }
    }

}
