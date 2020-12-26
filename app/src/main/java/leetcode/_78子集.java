package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _78子集 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backTrack(nums, track, 0);
        return lists;
    }

    private void backTrack(int[] nums, List<Integer> track, int index) {
        lists.add(new ArrayList<>(track));

        for (int i = index; i < nums.length; i++) {
            track.add(nums[i]);
            backTrack(nums, track, i + 1);
            track.remove(Integer.valueOf(nums[i]));
        }
    }

}
