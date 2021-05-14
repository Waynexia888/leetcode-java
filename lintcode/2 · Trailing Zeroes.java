public class Solution {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long res = 0;
        while (n > 0) {
            res += n / 5;
            n = n / 5;
        }
        return res;    
    }
}

time: O(log(n))