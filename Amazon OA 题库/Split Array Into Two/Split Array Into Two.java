// Given an array of integers, determine the number of ways the entire array be 
// split into two non-empty subarrays, left and right, such that the sum of 
// elements in the left subarray is greater than the sum of elements in the 
// right subarray.

// Example:
// arr =  [10, 4, -8, 7]
// There are three ways to split it into two non-empty subarrays:

// [10] and [4, -8, 7], left sum = 10, right sum = 3

// [10, 4] and [-8, 7], left sum = 10 + 4 = 14, right sum = -8 + 7 = -1

// [10, 4, -8] and [7], left sum = 6, right sum = 7

// The first two satisfy the condition that left sum > right sum, 
// so the return value should be 2.

public int numberOfWays(int[] arr) {
    if (arr == null || arr.length == 0) {
        return 0;
    }

    int[] prefixSum = new int[arr.length + 1];
    for (int i = 0; i < arr.length; i++) {
        prefixSum[i + 1] = prefixSum[i] + arr[i]; 
    }

    int count = 0;
    for (int i = 0; i < arr.length - 1; i++) {
        int leftSum = prefixSum[i + 1];
        int rightSum = prefixSum[arr.length] - prefixSum[i + 1];
        if (leftSum > rightSum) {
            count++;
        }
    }
    return count;
}

   [10, 4, -8, 7]
[0, 10, 14, 6, 13]

// time: O(N); space: O(n)