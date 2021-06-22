// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as 
// one sorted array.

// Note:

// The number of elements initialized in nums1 and nums2 are m and n respectively.
// You may assume that nums1 has enough space (size that is equal to m + n) to 
// hold additional elements from nums2.
// Example:

// Input:
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3

// Output: [1,2,2,3,5,6]

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int insertIndex = m + n - 1;
        
        while (pointer1 >= 0 && pointer2 >= 0) {
            if (nums1[pointer1] <= nums2[pointer2]) {
                nums1[insertIndex--] = nums2[pointer2--];
            } else {
                nums1[insertIndex--] = nums1[pointer1--];
            }
        }
        
        while (pointer2 >= 0) {
            nums1[insertIndex--] = nums2[pointer2--];
        }
    }
}

// 本题思想： 归并排序的归并步骤
// 只不过本题是在nums1后面加入元素，使之有序
// 因为nums1 和 nums2 都是有序的（从大到小）因此比较两个数组的最后一个数，哪个数大 就在nums1后面插入哪个数
// 时间复杂度: O(n)
// 空间复杂度: O(1)