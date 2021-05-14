public class Solution {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        long[] leftToRight = new long[nums.size()];
        long[] rightToLeft = new long[nums.size()];

        long left = 1L;
        leftToRight[0] = 1L;
        for (int i = 1; i < nums.size(); i++) {
            left = left * nums.get(i - 1);
            leftToRight[i] = left;
        }

        long right = 1L;
        rightToLeft[rightToLeft.length - 1] = 1L;
        for (int i = nums.size() - 2; i >= 0; i--) {
            right = right * nums.get(i + 1);
            rightToLeft[i] = right;
        }

        List<Long> results = new ArrayList<>();
        for (int i = 0; i < leftToRight.length; i++) {
            results.add(leftToRight[i] * rightToLeft[i]);
        }
        return results;
    }
}

// [2， 4， 6]
// [1,  2, 8] 从左往右，当前位置i 记录着从下标0到下标i - 1的乘积，第一个位置默认乘积为1
// [24, 6, 1] 从右往左，当前位置i 记录着从下标i + 1到下标length - 1的乘积，最后一个位置默认为1
// time: O(n); space: O(n)