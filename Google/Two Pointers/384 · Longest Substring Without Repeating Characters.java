Lintcode 384 · Longest Substring Without Repeating Characters
Leetcode 3. Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] map = new int[256];
        int length = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)] == 0) {
                map[s.charAt(j)]++;
                j++;
            }
            
            if (j >= s.length() || map[s.charAt(j)] != 0) {
                length = Math.max(length, j - i);
            }
            map[s.charAt(i)]--;
        }
        return length;
    }
}

///////////////////////////////////////////////////////
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int results = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && map.getOrDefault(s.charAt(j), 0) == 0) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            results = Math.max(results, j - i);
            
            char c = s.charAt(i);
            if (map.get(c) > 1) {
                map.put(c, map.get(c) - 1);
            } else {
                map.remove(c);
            }
        }
        return results;
    }
}
