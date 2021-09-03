Leetcode 78. Subsets

// -----选或不选-------
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp, results);
        return results;
    }
    
    private void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> results) {
        if (index == nums.length) {
            results.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[index]);
        dfs(nums, index + 1, temp, results);
        
        temp.remove(temp.size() - 1);
        dfs(nums, index + 1, temp, results);
    }
}
