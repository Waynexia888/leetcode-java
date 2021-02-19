public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length < 3) {
            return;
        }
        
        // count positive numbers and negative numbers
        int positive = 0, negative = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                positive++;
            } else {
                negative++;
            }
        }
   
        // suppose the first integer is positive, and the second integer is negative, and so on.
        partition(A, positive, negative);
        interleave(A, positive, negative);
    }
    
    private void partition(int[] A, int positive, int negative) {
        int flag = positive > negative ? 1 : -1;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            while (left <= right && A[left] * flag > 0) {
                left++;
            }
            // System.out.println(left);
            // System.out.println(A[left]);
            while (left <= right && A[right] * flag < 0) {
                right--;
            }
            // System.out.println(right);
            // System.out.println(A[right]);
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
    }

    private void interleave(int[] A, int positive, int negative) {
        int left = 1, right = A.length - 1;
        if (positive == negative) {
            right = A.length - 2;
        }
        
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left += 2;
            right -= 2;
        }
    }
}

// [-1, -2, -3, 4, 5, 6]
// 把所有> 0的数放到左边
// 把所有< 0 的数放到右边