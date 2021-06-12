// public class Remove_Duplicate_Numbers_in_Array {
//     /**
//      * @param nums: an array of integers
//      * @return: the number of unique integers
//      */
//     public int deduplication(int[] nums) {
//         // 时间复杂度O(nlogn) time， without extra space.
//         // 空间复杂度O(1)
//         // if (nums == null || nums.length == 0) {
//         // return 0;
//         // }

//         // Arrays.sort(nums);
//         // int left = 0;
//         // for (int right = 1; right < nums.length; right++) {
//         // if (nums[right] != nums[left]) {
//         // left++;
//         // nums[left] = nums[right];
//         // }
//         // }
//         // return left + 1;
//         // }

//         //////////////////////////////////////////////////////////////

//         // 时间复杂度O(n), 空间复杂度O(n)
//         // 使用hashset, HashSet contains unique elements only.
//         HashSet<Integer> set = new HashSet<Integer>();
//         for (int i = 0; i < nums.length; i++) {
//             set.add(nums[i]);
//         }

//         int result = 0;
//         for (int i : set) {
//             nums[result++] = i;
//         }
//         return result;
//     }
// }

///////////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // 同向双指针的模版问题
        // 首先得排序
        // i 记录当前最后一个unique number 的位置，即下标
        // j 负责找下一个unique number的位置
        // 时间复杂度O(nlogn), 空间复杂度O(1)

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int j = 1;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j >= nums.length) {
                break;
            }
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
            }
        }
        return i + 1;
    }
}