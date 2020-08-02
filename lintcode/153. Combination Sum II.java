public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length == 0) {
            return results;
        }
        
        //排序,方便后面去重步骤
        Arrays.sort(num);
        dfs(num, target, new ArrayList<>(), results, 0);
        return results;
    }
    
    private void dfs(int[] num, int target, List<Integer> temp, List<List<Integer>> results, int startIndex) {
        if (target == 0) {
            results.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = startIndex; i < num.length; i++) {
            // 去重
            if (i > startIndex && num[i] == num[i - 1]) {
                continue;
            }
            // 节省dfs步骤, 如果当前的数大于target， 则当前的数 以及后面的数都不用做dfs了
            if (num[i] > target) {
                break; 
            }
            
            temp.add(num[i]);
            dfs(num, target - num[i], temp, results, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}