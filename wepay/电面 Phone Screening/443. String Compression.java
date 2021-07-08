class Solution {
    public int compress(char[] chars) {
        // time: O(n); space: O(1)
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int result = 0; // store the index of the last element in the modified array
        int index = 0; // iterate the chars array
        while (index < chars.length) {
            char c = chars[index];
            int count = 0;
            while (index < chars.length && c == chars[index]) {
                index++;
                count++;
            }
            chars[result++] = c;
            if (count > 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    chars[result++] = ch;
                }
            }
        }
        return result;
    }
}