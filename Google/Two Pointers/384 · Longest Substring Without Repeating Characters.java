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