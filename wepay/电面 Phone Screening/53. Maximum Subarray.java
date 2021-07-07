class Solution {
    public int maxSubArray(int[] nums) {
        // time: O(n^2); space: O(n)
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = Math.max(sum, prefixSum[j + 1] - prefixSum[i]);
            }
        }
        return sum;
    }
}

////////////////////////////////////////////////////////////////////////
class Solution {
    public int maxSubArray(int[] nums) {
        // time: O(n); space: O(n)
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int min = 0;
        int sum = Integer.MIN_VALUE;
        for (int i = 1; i < prefixSum.length; i++) {
            sum = Math.max(prefixSum[i] - min, sum);
            min = Math.min(min, prefixSum[i]);
        }
        return sum;
    }
}

//    [-2,  1, -3, 4, -1, 2, 1, -5, 4]
// [0, -2, -1, -4, 0, -1, 1, 2, -3, 1]

/////////////////////////////////////////////////////////////////////

class Solution {
    public int maxSubArray(int[] nums) {
        // time: O(n); space: O(n)
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int min = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];  //prefixSum
            maxSum = Math.max(maxSum, sum - min); // maximum subarray sum starting from index 0 to index i
            min = Math.min(min, sum); // minimum subarray sum starting from index 0 to index i
        }
        return maxSum;
    }
}

//    [-2,  1, -3, 4, -1, 2, 1, -5, 4]
// [0, -2, -1, -4, 0, -1, 1, 2, -3, 1]