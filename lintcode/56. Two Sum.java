public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length == 0) {
            return new int[]{0, 0};
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {  
            int num = target - numbers[i];  
            if (map.containsKey(num)) {  
                return new int[]{map.get(num), i};  
            } else {
                map.put(numbers[i], i);  
            }
        }
        return new int[]{0, 0};
    }
}
// time: O(n); space: O(n);