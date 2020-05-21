public class Remove_Duplicate_Numbers_in_Array {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // 时间复杂度O(nlogn) time， without extra space.
        // 空间复杂度O(1)
        // if (nums == null || nums.length == 0) {
        // return 0;
        // }

        // Arrays.sort(nums);
        // int left = 0;
        // for (int right = 1; right < nums.length; right++) {
        // if (nums[right] != nums[left]) {
        // left++;
        // nums[left] = nums[right];
        // }
        // }
        // return left + 1;
        // }

        // 时间复杂度O(n), 空间复杂度O(n)
        // 使用hashset, HashSet contains unique elements only.
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int result = 0;
        for (int i : set) {
            nums[result++] = i;
        }
        return result;
    }
}