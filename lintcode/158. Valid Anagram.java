public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // time: O(n); space: O(1)
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] map = new int[256];
     
        
        // c - 'a' = Integer(0 ~ 25)
        for (char c : s.toCharArray()) {
            map[c]++;
            // System.out.println(map[c]);
        }
       
        // System.out.println(' ' - 'a');
        for (char c : t.toCharArray()) {
            map[c]--;
        }
        
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}