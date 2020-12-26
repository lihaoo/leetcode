package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _77组合 {

    List<List<Integer>> lists = new ArrayList<>();
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        List<Integer> track = new ArrayList<>();
        backTrack(n, track, 1);
        return lists;
    }

    private void backTrack(int nums, List<Integer> track, int current) {
        if (track.size() == k) {
            lists.add(new ArrayList<>(track));
            return;
        }

        for (int i = current; i <= nums; i++) {
            track.add(i);
            backTrack(nums, track, i + 1);
            track.remove(Integer.valueOf(i));
        }
    }
}
