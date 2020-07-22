public class Solution {
    /**
     * @param array: the input array
     * @return: the sorted array
     */
    public int[][] multiSort(int[][] array) {
        // Write your code here
        if (array == null || array.length == 0) {
            return new int[0][0];
        }
        
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                // true的情况不需要排
                if (!compare(array[i], array[j])) {
                    int temp = array[i][1];
                    array[i][1] = array[j][1];
                    array[j][1] = temp;
                    
                    temp = array[i][0];
                    array[i][0] = array[j][0];
                    array[j][0] = temp;
                }
            }
        }
        return array;
    }
    
    private boolean compare(int[] a, int[] b) {
        if (a[1] > b[1]) {
            return true;      //不用排序了
        }
        
        if (a[1] == b[1] && a[0] < b[0]) {
            return true;     // 这种情况也不需要排了
        }
        return false;
    }
}


