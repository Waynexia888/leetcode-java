Lintcode 1375 · Substring With At Least K Distinct Characters

public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        long results = 0;
        int numOfUniqueChars = 0;
        int[] map = new int[26];
        int end = 0;
        for (int start = 0; start < s.length(); start++) {
            while (end < s.length() && numOfUniqueChars < k) {
                char c = s.charAt(end);
                if (map[c - 'a'] == 0) {
                    numOfUniqueChars++;
                }
                map[c - 'a']++;
                end++;
            }

            if (numOfUniqueChars == k) {
                results += s.length() - end + 1;
            }

            char cc = s.charAt(start);
            if (map[cc - 'a'] == 1) {
                numOfUniqueChars--;
            }
            map[cc - 'a']--;
        }
        return results;
    }
}
// "a b c a b c a b c a b c"
//  i
//        j

///////////////////////////////////////////////////////

public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        long results = 0;
        Map<Character, Integer> map = new HashMap<>();
        int end = 0;
        for (int start = 0; start < s.length(); start++) {
            while (end < s.length() && map.size() < k) {
                char c = s.charAt(end);
                map.put(c, map.getOrDefault(c, 0) + 1);
                end++;
            }

            if (map.size() == k) {
                results += s.length() - end + 1;
            }

            char cc = s.charAt(start);
            if (map.get(cc) == 1) {
                map.remove(cc);
            } else {
                map.put(cc, map.get(cc) - 1);
            }
        }
        return results;
    }
}
