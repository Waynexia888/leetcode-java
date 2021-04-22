public class Solution {
    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        // write your code here
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) {
            return 0;
        }

        String s = String.valueOf(n);
        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1, s.length());
        }

        long res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res = res * 10 + s.charAt(i) - '0';
        }
        
        res = res * sign;

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)res;
    }
}
