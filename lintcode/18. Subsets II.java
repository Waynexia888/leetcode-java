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
        
        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), results, 0);
        return results;
    }
    
    private void dfs(int[] nums, List<Integer> temp, List<List<Integer>> results, int startIndex) {
        results.add(new ArrayList<>(temp));
        
        for (int i = startIndex; i< nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            
            temp.add(nums[i]);
            dfs(nums, temp, results, i + 1); 
            temp.remove(temp.size() - 1);
        }
    }
}