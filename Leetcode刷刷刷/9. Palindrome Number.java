class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = reverseInteger(x);
        return x == reverse;   
    }
    
    private int reverseInteger(int x) {
        int reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse;
    }
}

// time: O(n); space: O(1)