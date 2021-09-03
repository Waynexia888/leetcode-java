Leetcode 90. Subsets II

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp, results);
        return results;
    }
    
    private void dfs(int[] nums, int startIndex, List<Integer> temp, List<List<Integer>> results) {
        results.add(new ArrayList<>(temp));
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }
            
            temp.add(nums[i]);
            dfs(nums, i + 1, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}