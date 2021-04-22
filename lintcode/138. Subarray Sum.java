public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // 碰到子数组问题的时候，用前缀和prefixSum
        // sum(i~j) = prefixSum[j + 1] - prefixSum[i] = 0
        // prefixSum[j + 1] = prefixSum[i], 也就是说找到两个前缀和的值一样的即可
        // 用哈希表能在O(1)时间内快速找到两个前缀和值一样， 并且返回index
        // key： prefixSum； value: index (当前的下标)
        // array:         [-3,  1,  2,  -3,  4]
        // prefixSum:   0, -3, -2,  0,  -3,  1
        // index：     -1,  0,  1,  2,   3,  4
        // time: O(n); space: O(n)
        
        List<Integer> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
            
            results.add(map.get(prefixSum) + 1);
            results.add(i);
        }
        return results;
    }
}