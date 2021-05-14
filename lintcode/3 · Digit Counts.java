public class Solution {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        
        int count = k == 0 ? 1 : 0;
        for (int i = k; i <= n; i++) {
            int j = i;
            while (j > 0) {
                if (j % 10 == k) {
                    count++;
                }
                j = j / 10;
            }
        }
        return count;
    }
}
