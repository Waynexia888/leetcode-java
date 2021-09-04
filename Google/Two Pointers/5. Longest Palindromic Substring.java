Leetcode 5. Longest Palindromic Substring

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = getPalindromeFrom(s, i, i);
            if (longest.length() < oddPalindrome.length()) {
                longest = oddPalindrome;
            }
            String evenPalindrome = getPalindromeFrom(s, i, i + 1);
            if (longest.length() < evenPalindrome.length()) {
                longest = evenPalindrome;
            }
        }
        return longest;
    }
    
    private String getPalindromeFrom(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    } 
}