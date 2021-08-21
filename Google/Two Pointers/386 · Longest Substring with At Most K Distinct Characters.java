Lintcode 386 · Longest Substring with At Most K Distinct Characters
Leetcode 340. Longest Substring with At Most K Distinct Characters
同向双指针，不回头

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] map = new int[256]; // store the frequent of Character
        int uniqueChars = 0;
        int length = 0;
        
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && uniqueChars <= k) {  // "aaaaa", k = 1
                char c = s.charAt(j);
                if (map[c] == 0) {
                    uniqueChars++;
                } 
                if (uniqueChars > k) {
                    uniqueChars--;
                    break;
                }
                map[c]++;
                j++;
            } // exist the while loop, j = 3
            
            // update the results
            if (j >= s.length() || uniqueChars == k) {
                length = Math.max(length, j - i);
            }
            
            
            // next iterator, update i, and unique chars
            map[s.charAt(i)]--;
            if (map[s.charAt(i)] ==  0) {
                uniqueChars--;
            }
        }
        return length;
    }
}

// j = 0, 0 <= 2, u = 1, j = 1
// j = 1, 1 <= 2, u = 2, j= 2
// j = 2, 2 <= 2, u = 2, j = 3
// j = 3, 2 <= 2, u = 3 > 2, u = 2, break;

////////////////////////////////////////////////////////////////////////

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
            while (j < s.length() && map.size() <= k) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.size() > k) {
                    map.remove(c);
                    break;
                }
                j++;
            }
            if (j >= s.length() || map.size() == k) {
                res = Math.max(res, j - i);
            }
            
            char cc = s.charAt(i);
            if (map.getOrDefault(cc, 0) > 1) {
                map.put(cc, map.get(cc) - 1);
            } else {  // == 1
                map.remove(cc);
            }
        }
        return res;
    }
}

// e c e b a
// i 
//         j