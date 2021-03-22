public class Solution {
    /*
     * @param : A list of integers
     * 
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 全排列去重问题, 这个问题比全排列多两个步骤，
        // 一个是先要排列这个数组， 二是 去重，不能跳过第一个a去选下一个a
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums); // don't forget this step
        boolean[] isUsed = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        dfs(nums, isUsed, temp, results);
        return results;

    }

    private void dfs(int[] nums, boolean[] isUsed, List<Integer> temp, List<List<Integer>> results) {
        if (nums.length == temp.size()) {
            results.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i] == true) {
                continue;
            }
            // 去重
            if (i != 0 && nums[i] == nums[i - 1] && isUsed[i - 1] == false) {
                continue;
            }
            temp.add(nums[i]);
            isUsed[i] = true;
            dfs(nums, isUsed, temp, results);
            temp.remove(temp.size() - 1);
            isUsed[i] = false;
        }
    }
};

//////////////////////////////////////////////////////

public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, temp, results, visited);
        return results;
    }

    private void dfs(int[] nums, 
                     List<Integer> temp, 
                     List<List<Integer>> results, 
                     boolean[] visited) {
        if (temp.size() == nums.length) {
            results.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            visited[i] = true;
            dfs(nums, temp, results, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
};