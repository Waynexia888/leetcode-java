public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : A) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        int result = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                result = key;
            }
        }
        return result;
    }
}