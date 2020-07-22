public class Solution {
    /**
     * @param m: the limit
     * @param k: the sum of choose
     * @param arr: the array
     * @return: yes or no
     */
    public String depress(int m, int k, int[] arr) {
        // Write your code here.
        if (m == 0) {
            return "no";
        }
        
        if (arr == null || arr.length == 0 || k == 0) {
            return "yes";
        }
        
        Arrays.sort(arr);   // [1, 2, 3, 4, 5]
        
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        
        if (sum < m) {
            return "yes";
        }
        return "no";
    }
}