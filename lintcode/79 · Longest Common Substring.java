public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // time: O(n^3); space: O(1)
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (i + j + 1 > B.length()) {
                    break;
                }

                String s = B.substring(i, i + j + 1);
                if (A.indexOf(s) != -1) { // take O(n) time
                    result = Math.max(result, j + 1);
                }
            }
        }
        return result;
    }
}



