import java.util.*;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        combine(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void combine(int[] nums, int start,
                          List<Integer> current,
                          List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicate elements
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);

            combine(nums, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}