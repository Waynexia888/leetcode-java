public class Solution {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number) {
                index = i;
                map.put(nums[i], 1);
                break;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (index == -1) {
            return -1;
        }

        for (int i = 0; i <= index; i++) {
            if (map.get(nums[i]) == 1) {
                return nums[i];
            }
        }

        return -1;
    }
}