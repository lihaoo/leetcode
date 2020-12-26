package com.proguard.haoli.lib.力扣;

import java.util.ArrayList;
import java.util.List;

public class _39组合总和 {

    public static void main(String[] args) {
        _39组合总和 a = new _39组合总和();
        a.combinationSum(new int[]{ 2, 3, 6, 7 }, 7);
    }

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

        back();

        return lists;
    }

    private void back() {
        for (int i = 0; i < candidates.length; i++) {
            result += candidates[i];
            integers.add(candidates[i]);

            if (result == target) {
                lists.add(new ArrayList<>(integers));
                result -= integers.remove(integers.size() - 1);
                break;
            }

            if (result > target) {
                result -= integers.remove(integers.size() - 1);
                continue;
            }

            back();
        }

        if (!integers.isEmpty()) {
            result -= integers.remove(integers.size() - 1);
            integers.remove(integers.size() - 1);
        }
    }
}
