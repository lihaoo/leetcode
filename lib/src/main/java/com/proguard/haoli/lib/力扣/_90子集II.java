package com.proguard.haoli.lib.力扣;

import java.util.ArrayList;
import java.util.List;

import sun.rmi.runtime.Log;

public class _90子集II {


    public static void main(String[] args) {
        _90子集II a = new _90子集II();
        a.subsetsWithDup(new int[]{ 4, 4, 4, 1, 4 });
    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backTrack(nums, track, 0);


        return lists;
    }

    int ceng = 0;

    private void backTrack(int[] nums, List<Integer> track, int index) {
        for (int a : track) {
            System.out.print(a + " ");
        }
        System.out.println("   ");
        lists.add(new ArrayList<>(track));

        List<Integer> integers = new ArrayList<>();
        ceng++;

        for (int i = index; i < nums.length; i++) {
            if (integers.contains(nums[i])) {
                continue;
            }
            System.out.println("========= " + ceng);
            integers.add(nums[i]);

            track.add(nums[i]);
            backTrack(nums, track, i + 1);
            track.remove(Integer.valueOf(nums[i]));
            ceng--;
        }
    }
}
