Leetcode 15. 3Sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            twoSum(nums, i + 1, nums.length - 1, target, results);
        }
        return results;
    }
    
    private void twoSum(int[] nums, int i, int j, int target, List<List<Integer>> results) {
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(-target);
                results.add(temp);
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                } 
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
     }
}

// a + b + c = 0 -> b + c = -a

