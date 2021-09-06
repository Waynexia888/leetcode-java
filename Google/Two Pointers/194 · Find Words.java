Lintcode 194 · Find Words

public class Solution {
    /**
     * @param str: the string
     * @param dict: the dictionary
     * @return: return words which  are subsequences of the string
     */
    public List<String> findWords(String str, List<String> dict) {
        // O(n * m) where n is the size of dict, m is the length of str
        // space: O(1)
        List<String> results = new ArrayList<>();
        for (String s : dict) {  
            if (isMatch(s, str)) {
                results.add(s);
            }
        }
        return results;
    }

    private boolean isMatch(String s, String str) {
        int i = 0, j = 0;
        while (i < s.length() && j < str.length()) {
            if (s.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }

            if (i == s.length()) {
                return true;
            }

        }
        return false;
    }
}

// "book"
//      i 

// "bcogtadsjofisdhklasdj"
//                 j

//  ==, i++, j++
//  !=, j++
//  i == s.length(); return true;