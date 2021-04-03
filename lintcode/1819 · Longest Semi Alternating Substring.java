public class Solution {
    /**
     * @param s: the string
     * @return: length of longest semi alternating substring
     */
    public int longestSemiAlternatingSubstring(String s) {
        // i指针：负责循环字符串的每个位置
        // j指针：移到出现第二次的位置（即i - 1）有且仅当连续出现三个相同的字符

        int longestLen = 0;
        int count = 1;
        int j = 0; // 
        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);
            if (currChar != prevChar) {
                count = 1;
            } else {
                count++; 
                if (count >= 3) {
                    j = i - 1;
                    // count--;
                }
            }
            longestLen = Math.max(longestLen, i - j + 1);
        }

        return longestLen;
    }
}

// "b a a a a b b a b b b"
//        i 
//      j