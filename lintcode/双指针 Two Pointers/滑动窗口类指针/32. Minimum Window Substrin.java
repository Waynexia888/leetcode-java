public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // 滑动窗口型双指针类型题
        // 时间复杂度:O(256n); space O(1)
        int ans = Integer.MAX_VALUE;
        String minStr = "";
        
        int[] sourceHash = new int[256];
        int[] targetHash = new int[256];
        
        for (char ch : target.toCharArray()) {
            targetHash[ch]++;
        }
        
        int i = 0, j = 0;
        
        for (i = 0; i < source.length(); i++) {
            while (j < source.length() && !vaild(sourceHash, targetHash)) {
                sourceHash[source.charAt(j)]++;
                j++;
            }
            if (vaild(sourceHash, targetHash)) {
                if (j - i < ans) {
                    ans = Math.min(ans, j - i);
                    minStr = source.substring(i, j);
                }
            }
            sourceHash[source.charAt(i)]--;
        }
        return minStr;
    }
    
    private boolean vaild(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < 256; i++) {
            if (targetHash[i] > sourceHash[i]) {
                return false;
            }
        }
        return true;
    }
}