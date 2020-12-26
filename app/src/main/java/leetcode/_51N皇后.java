package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _51N皇后 {
    List<List<String>> result = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] nums = new int[n];

        List<Integer> track = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

        track(nums, track);

        for (List<Integer> integers : lists) {
            List<String> stringList = new ArrayList<>();
            // 'Q' 和 '.'
            for (int index : integers) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (index == i) {
                        stringBuilder.append("Q");
                    } else {
                        stringBuilder.append(".");
                    }
                }
                stringList.add(stringBuilder.toString());
            }
            result.add(stringList);
        }

        return result;
    }

    private void track(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            lists.add(new ArrayList<>(track));
            return;
        }

        for (int num : nums) {
            if (!track.contains(num) && !inLine(track, num)) {
                track.add(num);
                track(nums, track);
                track.remove(Integer.valueOf(num));
            }
        }
    }

    private boolean inLine(List<Integer> track, int num) {
        for (int i = 0; i < track.size(); i++) {
            if (track.get(i) + track.size() - i == num) {
                return true;
            }

            if (track.get(i) - track.size() + i == num) {
                return true;
            }
        }

        return false;
    }

}
