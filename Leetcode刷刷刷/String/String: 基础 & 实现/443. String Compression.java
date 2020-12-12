class Solution {
    public int compress(char[] chars) {
        int result = 0;
        int i = 0;
        while (i < chars.length) {
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current)  {
                count++;
                i++;
            }
            chars[result++] = current;
            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[result++] = c;
                }
            }
        }
        return result;
    }
}

Time: O(n);
Space: O(1)
