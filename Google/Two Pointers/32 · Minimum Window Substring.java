Lintcode 32 · Minimum Window Substring

public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        if (source == null || source.length() == 0) {
            return "";
        }

        int[] sourceMap = new int[256];
        int[] targetMap = new int[256];

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            targetMap[c]++;
        }

        int minSize = Integer.MAX_VALUE;
        String results = "";
        int end = 0;
        for (int start = 0; start < source.length(); start++) {
            while (end < source.length() && !isValid(targetMap, sourceMap)) {
                char c = source.charAt(end);
                sourceMap[c]++;
                end++;
            }

            if (isValid(targetMap, sourceMap)) {
                int length = end - start;
                if (length < minSize) {
                    minSize = length;
                    results = source.substring(start, end);
                }
            }

            char cc = source.charAt(start);
            sourceMap[cc]--;
        }
        return results;
    }

    private boolean isValid(int[] targetMap, int[] sourceMap) {
        for (int i = 0; i < 256; i++) {
            if (targetMap[i] > sourceMap[i]) {
                return false;
            }
        }
        return true;
    }

}