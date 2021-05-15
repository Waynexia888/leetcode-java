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

///////////////////////////////////////////

public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                j++;
                nums[j] = nums[i + 1];
            }
        }
        return j + 1;
    }
}

// 1 1 1 2
//     i
//   j


////////////////////////////////////////////////

public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}

// 1 1 1 2
//       i
//   j

// i 指针负责遍历，寻找下一个不重复的位置
// j 指针停在重复的位置


