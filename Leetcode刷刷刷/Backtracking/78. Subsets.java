// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        dfs(nums, results, new ArrayList<>(), 0);
        return results;   
    }
    
    private void dfs(int[] nums, List<List<Integer>> results, List<Integer> temp, int index) {
        results.add(new ArrayList<>(temp));
        
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, results, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

// 本题思想：回溯法-子集
// 空集也是一个子集，子集没有顺序之说
// index的作用是：对于多余的/算过的数字而言， 可以不用去管它了
// 时间复杂度: O(2^n * n)， 2^n 是方案个数， n是构造每个方案的时间
// 空间复杂度: O(2^n * n)
