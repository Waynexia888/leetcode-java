public class Longest_Substring_Without_Repeating_Characters {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // 两根指针- 滑动窗口, 以及哈希表记录字符的出现与否;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0; // [left,right) (left-closed, right-open).
        int maxLength = 0;

        while (left < s.length() && right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}