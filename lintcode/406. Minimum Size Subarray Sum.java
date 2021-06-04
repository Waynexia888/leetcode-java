public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // brute force, time: O(n^3); space: O(1), Time Limit Exceeded
        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; j++) {
                    sum += nums[k];
                }

                if (sum >= s) {
                    minLength = Math.min(minLength, j - i + 1);
                }
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return -1;
        }
        return minLength;
    }
}

/////////////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // using prefixSum to simplify brute force, time: O(n^2); space: O(n)
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = prefixSum[j + 1] - prefixSum[i];
                if (sum >= s) {
                    minLength = Math.min(minLength, j - i + 1);
                }
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return -1;
        }
        return minLength;
    }
}

//////////////////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // using prefixSum + binary search, time: O(nlogn); space: O(n)
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            // using binary search to find the first index j such that 
            // prefixSum[j + 1] - prefixSum[i]
            int j = getEndIndex(prefixSum, i, s);
            int sum = prefixSum[j + 1] - prefixSum[i];
            if (sum >= s) {
                minLength = Math.min(minLength, j - i + 1);
            }
            
        }

        if (minLength == Integer.MAX_VALUE) {
            return -1;
        }
        return minLength;
    }

    private int getEndIndex(int[] prefixSum, int i, int s) {
        int start = i, end = prefixSum.length - 2; // (n + 1) - 2 = n - 1
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (prefixSum[mid + 1] - prefixSum[i] >= s) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (prefixSum[start + 1] - prefixSum[i] >= s) {
            return start;
        }
        return end;
    }
}

///////////////////////////////////////////////////////////////////////


public class Minimum_Size_Subarray_Sum {
    /**
     * @param nums: an array of integers
     * @param s:    An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // 同向双指针问题：
        // 首先设置一个滑动窗口
        // 时间复杂度O(n), 空间复杂度O(1)
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int left = 0, right = -1;
        int sum = 0;
        int minLength = nums.length + 1;

        while (left < nums.length) {
            if (right + 1 < nums.length && sum < s) {
                right++; // 要保证right不超出范围
                sum += nums[right];
            } else { // sum >= s
                sum -= nums[left];
                left++;
            }

            if (sum >= s) {
                minLength = Math.min(minLength, right - left + 1);
            }
        }

        if (minLength == nums.length + 1) {
            return -1;
        }
        return minLength;

    }
}

///////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // using prefixSum + binary search, time: O(nlogn); space: O(n)
        
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }

            if (sum >= s) {
                minLength = Math.min(minLength, j - i);
            }
           sum -= nums[i]; 
        }

        if (minLength == Integer.MAX_VALUE) {
            return -1;
        }
        return minLength;
    }
}