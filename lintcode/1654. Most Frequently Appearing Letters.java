public class Solution {
    /**
     * @param str: the str
     * @return: the sum that the letter appears the most
     */
    public int mostFrequentlyAppearingLetters(String str) {
        // use hashmao, key: Character, value: Integer
        // time: O(n), space: O(n)
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int max = 0;
        for (Integer value : map.values()) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}