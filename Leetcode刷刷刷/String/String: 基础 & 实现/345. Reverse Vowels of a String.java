class Solution {
    public String reverseVowels(String s) {
        // time: O(n); space: O(n)
        if (s == null || s.length() == 0) {
            return s;
        }
        
        String vowels = "aeiouAEIOU";
        
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && vowels.indexOf(arr[left]) == -1) {
                left++;
            }
            while (left < right && vowels.indexOf(arr[right]) == -1) {
                right--;
            }
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }
}