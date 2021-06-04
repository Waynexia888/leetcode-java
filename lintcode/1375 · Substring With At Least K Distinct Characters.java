public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        long res = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && map.size() < k) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
                j++;
            }

            if (map.size() == k) {
                res += (s.length() - j + 1);
            }
            char cc = s.charAt(i);
            if (map.containsKey(cc)) {
                int count = map.get(cc);
                if (count > 1) {
                    map.put(cc, map.get(cc) - 1);
                } else {
                    map.remove(cc);
                }    
            } 
        }
        return res;
    }
}

// a b c a   b c a b c a b c
// i
//     (j-1) j            (n - 1)
// (n - 1) - (j - 1) + 1 = n - 1 - j + 1 + 1 = n - j + 1

///////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        long results = 0;
        if (s == null || s.length() == 0) {
            return results;
        }

        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && map.size() < k) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                j++;
            }
            if (map.size() == k) {
                results += s.length() - j + 1;
            }
            char cc = s.charAt(i);
            if (map.containsKey(cc)) {
                int count = map.get(cc);
                if (count > 1) {
                    map.put(cc, map.get(cc) - 1);
                } else {
                    map.remove(cc);
                }
            }
        }
        return results;
    }
}