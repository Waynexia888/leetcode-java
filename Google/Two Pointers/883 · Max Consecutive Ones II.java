Lintcode 883 · Max Consecutive Ones II

public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 0, count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count++;
            } 
            while (count > 1) {
                // 更新一下left指针的位置， 使得区间只包含1个0
                if (nums[left] == 0) {
                    left++;
                    count--;
                } else {
                    left++;
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

// [0, 0, 0, 1, 1, 0, 1, 0]
//                 r
//           l

// [1, 0, 1, 1, 0] 
//              r 
//        l

// [1, 0, 1, 0, 1]
//           r
//        l

// 维护一个区间，这个区间只能包含1个0.
// 当区间包含2个0的时候，不断地移动左边界，直到区间只包含1个0即可