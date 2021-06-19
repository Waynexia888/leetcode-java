class Solution {
    public String breakPalindrome(String palindrome) {
        // time: O(n); space: O(1)
        if (palindrome.length() < 2) {
            return "";
        }
        
        char[] arr = palindrome.toCharArray();
        
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return String.valueOf(arr);
                // return new String(arr);
            }
        }
        arr[arr.length - 1] = 'b';
        return new String(arr);
    }
}