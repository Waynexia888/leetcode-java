public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, results);
        return results;
    }

    private void dfs(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }

            subset.add(nums[i]);
            dfs(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}