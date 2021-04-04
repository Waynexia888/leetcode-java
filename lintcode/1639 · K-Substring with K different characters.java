public class Solution {
    /**
     * @param stringIn: The original string.
     * @param K: The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String stringIn, int K) {
        // time: O(n); space: O(n)
        
        Set<Character> set = new HashSet<>();
        Set<String> results = new HashSet<>();
        int i = 0, j = 0;
        while (j < stringIn.length()) {
            char c = stringIn.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
                if (set.size() == K) {
                    results.add(stringIn.substring(i, j));
                    set.remove(stringIn.charAt(i));
                    i++;
                }
            } else {
                set.remove(stringIn.charAt(i));
                i++;
            }
        }
        return results.size();
    }
}

// a b c a b c 
//     j  
//   i
