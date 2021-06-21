public class Solution {
    /**
     * @param n: 
     * @param k: 
     * @param len: 
     * @param num: //same as problem
     * @return: //return long
     */
    public long solve(int n, int k, int len, int[] num) {
        // time: O(n); space: O(n)
        long count = 0;

        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < num.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + num[i];
        }

        for (int i = len - 1; i < num.length; i++) {
            long sum = prefixSum[i + 1] - prefixSum[i + 1 - len];
            long avg = sum / len;
            if (avg > k) {
                count++;
            }
        }
        return count;
    }
}

// 给定一个长n的数组A， 求有多少个长度为l的子数组 其平均值大于k
// 对于任意一段子数组(i, j)的和 -> prefixSum[j + 1] - prefixSum[i]
// [2, 2, 2, 2, 5, 5, 5, 8]
// [      2, 2, 3, 4, 5, 6]
         