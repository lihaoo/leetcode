import java.util.ArrayList;
import java.util.List;

public class _90子集II {

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backTrack(nums, track, 0);
        return lists;
    }

    private void backTrack(int[] nums, List<Integer> track, int index) {
        lists.add(new ArrayList<>(track));

        List<Integer> integers = new ArrayList<>();

        for (int i = index; i < nums.length; i++) {
            if (integers.contains(nums[i])) {
                continue;
            }
            integers.add(nums[i]);

            track.add(nums[i]);
            backTrack(nums, track, i + 1);
            track.remove(Integer.valueOf(nums[i]));
        }
    }
}
