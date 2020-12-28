public class Solution {
    /**
     * @param s: string S
     * @param t: string T
     * @return: whether S can convert to T
     */
    public boolean canConvert(String s, String t) {
        // Write your code here
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return false;
        }
        
        if (s.length() < t.length()) {
            return false;
        }
        
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            
            if (j == t.length()) {
                return true;
            }
        }
        return false;
    }
}

时间复杂度： O(n);
空间复杂度: O(1)


