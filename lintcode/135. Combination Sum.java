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

//////////////////////////////////////////////////////
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        int[] nums = removeDuplicates(candidates);
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp, results, target);
        return results;
    }

    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);

        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[index] != candidates[i]) {
                index++;
                candidates[index] = candidates[i];
            }
        }

        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }
        return nums;
    }

    private void dfs(int[] nums, 
                    int startIndex, 
                    List<Integer> temp, 
                    List<List<Integer>> results, 
                    int remainingTarget) {
        // base case
        if (remainingTarget < 0) {
            return;
        }

        if (remainingTarget == 0) {
            results.add(new ArrayList<Integer>(temp));
        }

        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i, temp, results, remainingTarget - nums[i]);
            temp.remove(temp.size() - 1);
        }


    }
}
        