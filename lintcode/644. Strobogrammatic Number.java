public class Solution {
    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        // 使用哈希表记录一下可能的mirror number
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        map.put('1', '1');

        // 相向双指针
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(left)) || map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}