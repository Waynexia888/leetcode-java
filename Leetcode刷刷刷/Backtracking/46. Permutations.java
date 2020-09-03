// Given a collection of distinct integers, return all possible permutations.

// Example:

// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        boolean[] visited = new boolean[nums.length];
        dfs(nums, results, new ArrayList<>(), visited);
        return results;
    }
    
    private void dfs(int[] nums, List<List<Integer>> results, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            results.add(new ArrayList<>(temp)); // deep copy, copy content
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            temp.add(nums[i]);
            visited[i] = true;
            dfs(nums, results, temp, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}

// 本题思想： 回溯法-全排列
// 排列问题是跟顺序有关的
// 使用visited 布尔数组来记录数字是否被访问过
// 时间复杂度：O(n! * n), n! 是方案个数， n是构造每个方案的时间
// 空间复杂度: O(n!)
// deep copy深拷贝，拷贝的是内容
// soft copy浅拷贝，拷贝的是内存地址的引用