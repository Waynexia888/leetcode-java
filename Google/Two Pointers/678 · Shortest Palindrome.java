Lintcode 678 · Shortest Palindrome
Leetcode 214. Shortest Palindrome

public class Solution {
    /**
     * @param str: String
     * @return: String
     */
    public String shortestPalindrome(String str) {
        // time: O(n^2), space: O(n)
        if (isPalindrome(str)) {
            return str;
        }

        // find the largest palindrome in the original string, from index 0 to endIndex
        int endIndex = 0;
        String largestPalindrome = "";
        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.substring(0, i + 1);
            if (isPalindrome(s) && s.length() > largestPalindrome.length()) {
                largestPalindrome = s;
                endIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >  endIndex; i--) {
            sb.append(str.charAt(i));
        }
        sb.append(str);
        return sb.toString();
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

