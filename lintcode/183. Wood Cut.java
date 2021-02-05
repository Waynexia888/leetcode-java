public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        
        // 第一步，确定答案范围
        int start = 1;
        int end = 0; // 一开始假设上限是0， 后面打擂台
        
        for (int wood : L) {
            end = Math.max(end, wood);
        }
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 我们要找>= k 木头数的最后一位，套用 458. Last Position of Target模版
            if (getWoodPieces(L, mid) >= k) { // 判断答案是偏大还是偏小
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (getWoodPieces(L, end) >= k) {
            return end;
        }
        
        if (getWoodPieces(L, start) >= k) {
            return start;
        }
        return 0;
    }
    
    private int getWoodPieces(int[] L, int len) {
        int pieces = 0;
        for (int woodLength : L) {
            pieces += (woodLength / len);
        }
        return pieces;
    }
}
time: O(n log Len), where Len is the longest length of the wood.
