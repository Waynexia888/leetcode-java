// nums = [2, 8, 5, 2, 6]
// Sort the nums using bubble sort!

public static void bubbleSort(int[] nums) {
    boolean flag = false;
    for (int i = 0; i < nums.length; i++) {
        flag = false;
        for (int j = nums.length - 1; j > i; j--) {
            if (nums[j] < nums[j - 1]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                flag = true;
            }
        }
        if (!flag) {
            break;
        }
    }
}

// 冒泡排序总结：
// 标志变量flag用于记录每趟冒泡排序是否发生数据元素位置交换。如果没有发生交换，
// 说明序列已经有序了，不必继续进行下去了。

// 1）时间复杂度

// 在设置标志变量之后：
// 当原始序列“正序”排列时，冒泡排序总的比较次数为n-1，移动次数为0，
// 也就是说冒泡排序在最好情况下的时间复杂度为O(n)；

// 当原始序列“逆序”排序时，冒泡排序总的比较次数为n(n-1)/2，
// 移动次数为3n(n-1)/2次，所以冒泡排序在最坏情况下的时间复杂度为O(n^2)；

// 当原始序列杂乱无序时，冒泡排序的平均时间复杂度为O(n^2)。

// （2）空间复杂度
// 冒泡排序排序过程中需要一个临时变量进行两两交换，所需要的额外空间为1，因此空间复杂度为O(1)。

// （3）稳定性
// 冒泡排序在排序过程中，元素两两交换时，相同元素的前后顺序并没有改变，所以冒泡排序是一种稳定排序算法。