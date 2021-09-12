Leetcode 47. Permutations II

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        dfs(nums, visited, temp, results);
        return results;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> results) {
        if (temp.size() == nums.length) {
            results.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            
            temp.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, temp, results);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}