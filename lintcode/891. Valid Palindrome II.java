public class Solution {
    /**
     * @param s: a string
     * @return boolean: whether you can make s a palindrome by deleting at most one
     *         character
     */
    public boolean validPalindrome(String s) {
        // 相向双指针问题，时间复杂度O(n), 空间复杂度O(1)
        // follow up: helper function removeOneCharacter() 做的事情根validPalindrome()基本一样，
        // 那么能否简化呢？
        if (s == null) {
            return false;
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return removeOneCharacter(s, left + 1, right) || removeOneCharacter(s, left, right - 1);
            }
        }
        return true; // while 循环结束后, 如果是left >= right 这种情况， return true；
    }

    public boolean removeOneCharacter(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

}