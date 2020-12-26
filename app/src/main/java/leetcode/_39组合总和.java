package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _39组合总和 {

    private List<Integer> integers;
    private List<List<Integer>> lists;
    private int result;
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        integers = new ArrayList<>();
        lists = new ArrayList<>();
        result = 0;

        back(0);

        return lists;
    }

    private void back(int startIndex) {
        if (result == target) {
            lists.add(new ArrayList<>(integers));
            result -= integers.remove(integers.size() - 1);
            return;
        }

        if (result > target) {
            result -= integers.remove(integers.size() - 1);
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            result += candidates[i];
            integers.add(candidates[i]);

            back(i);

            if (!integers.isEmpty()) {
                result -= integers.remove(integers.size() - 1);
            }
        }

    }
}
