package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _22括号生成 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        List<String> track = new ArrayList<>();
        backtrack(track, n);
        return result;
    }

    private void backtrack(List<String> track, int n) {
        if (track.size() == 2 * n) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : track) {
                stringBuilder.append(s);
            }
            result.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < 2; i++) {
            track.add(i % 2 == 0 ? "(" : ")");
            if (getLeftC(track) < getRightC(track)
                    || getLeftC(track) > n || getRightC(track) > n) {
                track.remove(track.size() - 1);
                continue;
            }
            backtrack(track, n);
            track.remove(track.size() - 1);
        }
    }

    int getLeftC(List<String> track) {
        int i = 0;
        for (String s : track) {
            if (s.equals("(")) {
                i++;
            }
        }
        return i;
    }

    int getRightC(List<String> track) {
        int i = 0;
        for (String s : track) {
            if (s.equals(")")) {
                i++;
            }
        }
        return i;
    }
}
