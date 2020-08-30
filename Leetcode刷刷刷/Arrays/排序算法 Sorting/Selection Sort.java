public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // selection sort
        // 时间复杂度O(n^2), 空间复杂度O(1)
        // 它的工作原理是：第一次从待排序的数据元素中选出最小（或最大）的一个元素，
        // 存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小（大）元素
        for (int i = 0; i < A.length - 1; i++) {
            int minNumber = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minNumber]) {
                    minNumber = j;
                }
            }
            int temp = A[i];
            A[i] = A[minNumber];
            A[minNumber] = temp;
        }
    }
}