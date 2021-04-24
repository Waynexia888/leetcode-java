public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                count++;
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return count;
    }
}


//////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                count++;
                left++;
                right--;
                //后面一个数跟前面一个数进行比较，如果相等，就跳过该位置
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                } 
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
        return count;

    }
}


/////////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (Integer key : map.keySet()) {
            // {1: 2, 2: 1, 45: 1, 46: 2}
            int another = target - key;
            if (key != another && map.containsKey(another) && key < another) {
                count++;
                continue;
            }
            if (key == another && map.getOrDefault(another, 0) >= 2) {
                count++;
                continue;
            }
        }
        return count;
    }
}