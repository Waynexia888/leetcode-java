public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // 使用hashmap来记录每个字符出现的个数
        // time: o(n), space: o(n)
        Map<Character, Integer> map = new HashMap<>();
        
        for (int k = 0; k < str.length(); k++) {
            char c = str.charAt(k);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        return '0';
    }
}