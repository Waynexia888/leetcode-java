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

////////////////////////////////////////////////////////
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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
            temp.add(nums[i]);
            dfs(nums, i + 1, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}

// 考虑 下一个往当前集合放的数是什么
// 每次从一个数一条路走到底，然后逐渐往上一层回溯
// 图中的每一个节点都是一个答案
