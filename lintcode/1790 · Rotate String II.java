public class Solution {
    /**
     * @param str: An array of char
     * @param left: a left offset
     * @param right: a right offset
     * @return: return a rotate string
     */
    public String RotateString2(String str, int left, int right) {
        // time: O(n); space: O(n)
      
        String str1 = "";
        String str2 = "";
        String newStr = "";
        int offset = 0;
        if (left >= right) {
            offset = (left - right) % str.length();
            str1 = str.substring(0, offset);
            str2 = str.substring(offset, str.length());
            newStr = swap(str1, str2);
        } else {
            offset = (right - left) % str.length();
            str1 = str.substring(0, str.length() - offset);
            str2 = str.substring(str.length() - offset, str.length());
            newStr = swap(str1, str2);
        }
        return newStr;
    }

    private String swap(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        sb.append(s2);
        sb.append(s1);
        return sb.toString();
    }
}


