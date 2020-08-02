public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // DFS
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        // 排序，是为了方便后面的去重
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), results, 0);
        return results;
    }
    
    private void dfs(int[] candidates, int target, List<Integer> temp, List<List<Integer>> results, int startIndex) {
        // 递归的出口
        if (target == 0) {
            results.add(new ArrayList<>(temp)); // deep copy
            return;
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            // 之前的sort步骤是方便现在的去重步骤
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            if (candidates[i] > target) {
                break;
            }
            
            // dfs传入的是i 而不是i + 1 是因为同一个数可以重复使用
            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], temp, results, i);
            temp.remove(temp.size() - 1);
        }
        
    }
}