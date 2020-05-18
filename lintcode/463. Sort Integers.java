public class Sort_Integers {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // 实现一个归并排序
        if (A == null || A.length == 0) {
            return;
        }
        // //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    private void mergeSort(int[] A, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        // 下面4行代码是left< right的case：
        int mid = (left + right) / 2;
        mergeSort(A, left, mid, temp); // 左边归并排序，使得左子序列有序
        mergeSort(A, mid + 1, right, temp); // 右边归并排序，使得右子序列有序
        merge(A, left, right, temp); // 将两个有序子数组合并操作

    }

    private void merge(int[] A, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        int leftIndex = left; // 左序列指针
        int rightIndex = mid + 1; // 右序列指针
        int tempIndex = leftIndex; // 临时数组指针
        while (leftIndex <= mid && rightIndex <= right) {
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
        while (rightIndex <= right) {
            temp[tempIndex++] = A[rightIndex++];
        }

        // //将temp中的元素全部拷贝到原数组中
        for (int i = left; i <= right; i++) {
            A[i] = temp[i];
        }

    }

    // 归并算法参考资料，
    // https://www.cnblogs.com/chengxiao/p/6194356.html
}