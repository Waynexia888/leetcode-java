class Solution {
    public String reverseStr(String s, int k) {
        // time: O(n); space: O(n)
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            int j = Math.min(i + k - 1, s.length() - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return new String(arr);
    }
    
    private void swap(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}