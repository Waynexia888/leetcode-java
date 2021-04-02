public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length== 0) {
            return "";
        }
        String result = new String();

        String s = strs[0];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j;
            for (j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1 || c != strs[j].charAt(i)) {
                    break;
                }
            }
            if (j == strs.length) {
                result += s.charAt(i);
            }
        }
        return result;
    }
}