Lintcode 928 · Longest Substring with At Most Two Distinct Characters
Leetcode 159. Longest Substring with At Most Two Distinct Characters

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int length = 0;
        
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && map.size() <= 2) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.size() > 2) {
                    map.remove(c);
                    break;
                }
                j++;
            }
            
            if (j >= s.length() || map.size() == 2) {
                length = Math.max(length, j - i);
            }
            
            char cc = s.charAt(i);
            if (map.get(cc) > 1) {
                map.put(cc, map.get(cc) - 1);
            } else {
                map.remove(cc);
            }
        }
        return length;
    }
}