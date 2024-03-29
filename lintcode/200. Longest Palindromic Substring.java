public class Longest_Palindromic_Substring {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // 基于中心点枚举法
        // 时间复杂度：O(n^2)
        // cdzdc
        // ^ n个奇数长度的回文串中心点
        // a|b|d|d|b|a
        // ^ ^ n - 1 个偶数长度的回文串中心点
        // L R 背向双指针移动，直到L != R 跳出循环

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

    public String getPalindromeFrom(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left + 1, right); // 跳出循环后，取值在[left + 1, right -1]，前闭后闭
    }
}

//////////////////////////////////////////////////

public class Solution {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return null;
        }
        
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subStr = s.substring(i, j + 1);
                if (isPalindrome(s, i, j) && subStr.length() > result.length()) {
                    result = subStr;
                }
            }
        }
        return result;
    }
    
    
  
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}