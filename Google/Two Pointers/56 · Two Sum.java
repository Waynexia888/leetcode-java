Leetcode 56 · Two Sum

public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] results = new int[2];
        Map<Integer, Integer> map = new HashMap<>(); // current num -> index
        for (int i = 0; i < numbers.length; i++) {
            int curNumber = numbers[i];
            if (map.containsKey(target - curNumber)) {
                results[0] = map.get(target - curNumber);
                results[1] = i;
                return results;
            }
            map.put(curNumber, i);
        }
        return results;
    }
}