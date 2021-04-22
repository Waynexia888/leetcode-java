public class Valid_Palindrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // 使用两根指针, 一头一尾

        // 时间复杂度O(n), 空间复杂度O(1)
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // 当不是数字或者字符时，指针移动，否者不移动， 进入if语句比较
            while (left < right && !isValid(s.charAt(left))) {
                left++;
            }

            while (left < right && !isValid(s.charAt(right))) {
                right--;
            }

            // 在此做判断
            if (left < right && (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 题目给定char只考虑数字和字母
    // isLetter(), isDigit()
    // https://www.javatpoint.com/post/java-character-isdigit-method
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}

///////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] ss = s.toCharArray();
        
        int left = 0, right = ss.length - 1;
        while (left < right) {
            while (left < right && (!Character.isLetter(ss[left]) && !Character.isDigit(ss[left]))) {
                left++;
            }
            while (left < right && (!Character.isLetter(ss[right]) && !Character.isDigit(ss[right]))) {
                right--;
            }
            if (left < right && Character.toLowerCase(ss[left]) != Character.toLowerCase(ss[right])) {
                return false; 
            }
            left++;
            right--;
        }
        return true;
    }
}