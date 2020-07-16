public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // 求区间，prefixsum前缀和
        // HashMap: key -> prefixSum; value -> index
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            } else {
                results.add(map.get(prefixSum) + 1);
                results.add(i);
                break;
            }
            
        }
        return results;
    }
}