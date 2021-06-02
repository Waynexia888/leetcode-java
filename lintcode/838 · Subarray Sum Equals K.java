public class Solution {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the number of continuous subarrays whose sum equals to k
     */
    public int subarraySumEqualsK(int[] nums, int k) {
        // write your code here
        int count = 0;
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prefixSum.length; i++) {
            if (map.containsKey(prefixSum[i] - k)) {
                count += map.get(prefixSum[i] - k);
                System.out.println(count);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        return count;
    }
}


// nums =        [2, 1, -1, 1, 2]

// prefixSum: [0  2  3  2   3  5]
// hashmap:   {0: 1, 2: 2, 3: 2, 5: 1}
// count:     

// prefixSum[j] - prefixSum[i] == k?

// prefixSum Array:
// prefixSum[x] = sum of subarray(0, x) = nums[0] + nums[1] + ... + nums[x]
//                                      = prefixSum[x - 1] + nums[x]

// prefixSum[0] = 0

// 计算子数组从下标i到下标j之间的所有数之和：
// subarray(i, j) = prefixSum[j] - prefixSum[i - 1] = k


// prefixSum[x] = sum of subArray(0, x) = nums[0] + nums[1] + ... nums[x]
//                                      = prefixSum[x - 1] + nums[x]
// index:           0  1  2
// nums =          [1, 1, 1]
// prefixSum =   0  1  2  3

//////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the number of continuous subarrays whose sum equals to k
     */
    public int subarraySumEqualsK(int[] nums, int k) {
        // write your code here
        int count = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
        }
        return count;
    }
}