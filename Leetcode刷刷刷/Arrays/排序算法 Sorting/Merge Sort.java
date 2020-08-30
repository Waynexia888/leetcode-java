public class Sort_Integers {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // 实现一个归并排序 Merge Sort, 先局部有序，后整体有序
        // 该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divid)成一些小的问题然后递归求解，
        // 而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之
        // 时间复杂度O(nlogn), 空间复杂度O(n)，相对于快速排序而言，是一个稳定的排序
        // 因为耗费O(n)的额外空间，实际运行的时间会比快速排序慢
        if (A == null || A.length == 0) {
            return;
        }
        // //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    // 分的过程时间复杂度O(n)
    private void mergeSort(int[] A, int start, int end, int[] temp) {
        // // 递归的出口
        if (start >= end) {
            return;
        }
        // 下面4行代码是left< right的case：
        int mid = (start + end) / 2;
        mergeSort(A, start, mid, temp); // 左边归并排序，使得左子序列有序
        mergeSort(A, mid + 1, end, temp); // 右边归并排序，使得右子序列有序
        merge(A, start, end, temp); // 将两个有序子数组合并操作

    }
    
    // merge的步骤, 将上述两个有序的左右两个数组进行合并
    // 合的过程时间复杂度O(nlogn)
    private void merge(int[] A, int start, int end, int[] temp) {
        int mid = (start + end) / 2;
        int leftIndex = start; // 左序列指针
        int rightIndex = mid + 1; // 右序列指针
        int tempIndex = leftIndex; // 临时数组指针
        while (leftIndex <= mid && rightIndex <= end) {
            if (A[leftIndex] < A[rightIndex]) {
                temp[tempIndex++] = A[leftIndex++];
            } else {
                temp[tempIndex++] = A[rightIndex++];
            }
        }

        // 将左边剩余元素填充进temp中
        while (leftIndex <= mid) {
            temp[tempIndex++] = A[leftIndex++];
        }

        // 将右序列剩余元素填充进temp中
        while (rightIndex <= end) {
            temp[tempIndex++] = A[rightIndex++];
        }

        // //将temp中的元素全部拷贝到原数组中
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }

    }

    // 归并算法参考资料，
    // https://www.cnblogs.com/chengxiao/p/6194356.html
}