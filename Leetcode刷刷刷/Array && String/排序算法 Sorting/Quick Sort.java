public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // 实现快速排序Quick Sort
        // 先选取一个标杆pivot, 然后把小于pivot的放在左边， 把大于pivot的放在右边，这是先整体有序
        // 最后用递归来实现局部有序
        // 时间复杂度O(nlogn), 空间复杂度O(1); 快速排序不稳定
        if (A == null || A.length == 0) {
            return;
        }

        quickSort(A, 0, A.length - 1); // 在0到length-1的区间内对数组A进行快速排序
    }

    private void quickSort(int[] A, int start, int end) {
        // 递归的出口
        if (start >= end) {
            return;
        }

        // 设置两根指针left，right，以及标杆pivot
        int left = start, right = end;

        // 注意点1: pivot, get value not index, pivot设置好后不能改变
        int pivot = A[(start + end) / 2];

        // 注意点2: partition 过程, left <= right, not left < right
        while (left <= right) {

            // 找到不属于pivot左半部分的元素
            // 注意点3: A[left] < pivot, not <=
            // 比如： [1, 1, 1, 1, 1, 1, 1]
            while (left <= right && A[left] < pivot) {
                left++;
            }
            // 找到不属于pivot右半部分的元素
            while (left <= right && A[right] > pivot) {
                right--;
            }
            // 如果找到了上述的元素， 在这儿swap一下
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        //while循环结束后， 即right在left左边, 因此对[start, right]左半部分，
        //[left, end]右半部分进行快速排序
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}