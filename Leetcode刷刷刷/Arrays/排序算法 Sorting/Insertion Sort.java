public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // insertion sort 
        // 插入排序原理很简单，讲一组数据分成两组，分别将其称为有序数组与无序数组。
        // 每次从无序数组中取出一个元素，与有序数组的元素进行比较，
        // 并找到合适的位置，将该元素插到有序数组当中。就这样，每次插入一个元素，
        // 有序数组增加，无序数组减少。
        // 时间复杂度O(n^2), 空间复杂度O(1)
        if (A == null || A.length == 0) {
            return;
        }
        
        for (int i = 1; i < A.length; i++) {
            for (int j = i; j > 0; j--) {
                if (A[j] < A[j - 1]) {
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}