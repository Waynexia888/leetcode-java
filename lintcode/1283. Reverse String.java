public class Reverse_String {
    /**
     * @param s: a string
     * @return: return a string
     */
    public String reverseString(String s) {
        // 背向双指针问题
        // java 不允许字符串的修改
        // 所以先创建一个数组,数组里都是字符

        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] chars = new char[s.length()];
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            chars[left] = s.charAt(right);
            chars[right] = s.charAt(left);
            left++;
            right--;
        }
        return new String(chars);

    }
}