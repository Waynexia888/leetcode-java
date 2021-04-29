public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    if (map.size() == k) {
                        break;
                    }
                    map.put(c, 1);
                }
                j++;
            }
            res = Math.max(res, j - i);
            char cc = s.charAt(i);
            if (map.containsKey(cc)) {
                if (map.get(cc) > 1) {
                    map.put(cc, map.get(cc) - 1);
                } else {
                    map.remove(cc);
                }
            }
        }
        return res;
    }
}

// e c e b a
// i 
//         j