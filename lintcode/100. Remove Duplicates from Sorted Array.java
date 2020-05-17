public class Remove_Duplicates_from_Sorted_Array {
    public class Solution {
        /*
         * @param nums: An ineger array
         * 
         * @return: An integer
         */
        public int removeDuplicates(int[] nums) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int slow = 0, fast = 1;
            while (fast < nums.length) {
                if (nums[slow] != nums[fast]) {
                    slow += 1;
                    nums[slow] = nums[fast];
                }
                fast += 1;
            }
            return slow + 1;
        }
    }
}