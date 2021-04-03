public class Solution {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }

        int oddNumber = 0; // how many different odd number they have
        
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] % 2 == 1) {
                oddNumber++;
            }
        }

        if (oddNumber > 1) {
            return false;
        }
        return true;
    }
}