class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        
        int neg = 1;
        if (x < 0) {
            neg = -1;
            x = -x;
        }
        
        long reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        
        reverse = reverse * neg;
        
        if (reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)reverse;
    }
}


// time: O(n); space: O(1)