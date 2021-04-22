public class Longest_Palindrome {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }

        int count = 0;
        for (int v : hashMap.values()) {
            if (v % 2 == 0) {
                count += v;
            } else if (v != 1 && v % 2 == 1) {
                count = count + v - 1;
            }
        }

        // "abba" "abcba"
        if (count < s.length()) {
            return count + 1;
        } else {
            return count;
        }
    }
}

///////////////////////////////////////////////////

public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
       
        int[] alpha = new int[256];
        int[] Alpha = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a') {
                alpha[c]++;
            } else {
                Alpha[c]++;
            }  
        }

        int len = s.length();
        for (int i = 0; i < 256; i++) {
            if (alpha[i] % 2 == 1) {
                len--;
            }
            if (Alpha[i] % 2 == 1) {
                len--;
            }
        }
        
        return len == s.length() ? len : len + 1;
    }
}

