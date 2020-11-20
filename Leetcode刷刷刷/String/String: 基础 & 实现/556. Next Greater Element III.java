class Solution {
    public int nextGreaterElement(int n) {
        // the goal of this problem is to find the next permutation
        // find the first decreasing element, from the right
        // time: O(n); space: O(n)
        char[] arr = (n + "").toCharArray();
        // e.g. [1, 5, 8, 4, 7, 6, 5, 3, 1]
        //                i        j
        int i = arr.length - 2;
        while (i >= 0 && arr[i + 1] <= arr[i]) {
            i--;
        }
        // e.g. [9, 8, 7, 5, 3, 2, 1], return -1
        if (i < 0) {
            return -1;
        }
        // find the first number larger than arr[i] 
        int j = arr.length - 1;
        while (j >= 0 && arr[j] <= arr[i]) {
            j--;
        }
        // swap these two number
        swap(arr, i, j);
        // reverse number start at i + 1 to the end
        reverse(arr, i + 1);
        // get the new value, and compare it the 32-bit integer
        long val = Long.parseLong(new String(arr));
        return val <= Integer.MAX_VALUE ? (int)val : -1;
    }
    
    private void swap(char[] arr, int left, int right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
    }
    
    private void reverse(char[] arr, int start) {
        int i = start, j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++; 
            j--;
        }
    }
}