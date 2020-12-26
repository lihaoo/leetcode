package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _46全排列 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> track = new ArrayList<>();
        track(nums, track);
        return lists;
    }

    private void track(int[] nums, ArrayList<Integer> track) {
        if (track.size() == nums.length) {
            lists.add(new ArrayList<>(track));
            return;
        }

        for (int num : nums) {
            if (!track.contains(num)) {
                track.add(num);
                track(nums, track);
                track.remove(Integer.valueOf(num));
            }
        }
    }
}
