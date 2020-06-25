public class Solution {
    /*
     * @param nums: A list of integers.
     * 
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        dfs(nums, isUsed, temp, results);
        return results;
    }

    private void dfs(int[] nums, boolean[] isUsed, List<Integer> temp, List<List<Integer>> results) {
        if (nums.length == temp.size()) {
            results.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i] == true) {
                continue;
            }

            temp.add(nums[i]);
            isUsed[i] = true;
            dfs(nums, isUsed, temp, results);
            temp.remove(temp.size() - 1);
            isUsed[i] = false;

        }
    }
}