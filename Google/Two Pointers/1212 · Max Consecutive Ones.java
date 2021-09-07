Lintcode 1212 · Max Consecutive Ones

public class Solution {
    /**
     * @param nums: a binary array
     * @return:  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // Write your code here
        int i = 0, j = 0;
        int maxLength = Integer.MIN_VALUE;
        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] != 1) {
                i++;
            }
            j = i;
            while (j < nums.length && nums[j] == 1) {
                j++;
            }
            
            maxLength = Math.max(maxLength, j - i);
            i = j;
        }
        return maxLength;
    }
}

// [0, 0, 1,1,0,1,1,1]
//                    i
//                    j

//////////////////////////////////////////////////

public class Solution {
    /**
     * @param nums: a binary array
     * @return:  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // Write your code here
        int maxLength = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                maxLength = Math.max(maxLength, count);
            } else { // nums[i] == 0
                count = 0;
            }
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}