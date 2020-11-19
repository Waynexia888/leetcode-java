class Solution {
    public boolean isOneEditDistance(String s, String t) {
        // time: O(n); space: O(1)
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                // s = abced, t = abjed
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                // s = abcd, t = abd
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                // s = ab, t = acb
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        // s = abc, t = abcdef
        return Math.abs(s.length() - t.length()) == 1;
    }
}