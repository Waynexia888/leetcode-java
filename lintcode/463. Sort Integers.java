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


/////////////////////////////////////////////////////////////
// 下面是快速排序算法的实现, Quick Sort

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

/////////////////////////////////////////////////////////
// 选择排序， Selection Sort

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

///////////////////////////////////////////////////////////
// insertion sort 插入排序

public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // insertion sort 
        // 插入排序原理很简单，讲一组数据分成两组，分别将其称为有序数组与无序数组。每次从无序数组中取出一个元素，与有序数组的元素进行比较，并找到合适的位置，将该元素插到有序数组当中。就这样，每次插入一个元素，有序数组增加，无序数组减少。
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