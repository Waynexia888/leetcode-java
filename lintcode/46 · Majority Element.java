public class Solution {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int count = 0;
        int majorNum = 0;
        for (Integer num : nums) {
            if (count == 0) {
                majorNum = num;
                count++;
            } else {
                count += majorNum == num ? 1 : -1;
            }
        }
        return majorNum;
    }
}
///////////////////////////////////////////////////
public class Solution {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > (nums.size() / 2)) {
                return key;
            }
        }
        return -1;
    }
}

// hashmap: time: O(n); space: O(n)