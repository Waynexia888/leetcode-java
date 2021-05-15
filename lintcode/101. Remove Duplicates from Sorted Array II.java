public class Remove_Duplicates_from_Sorted_Array_II {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int count = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] == nums[left]) {
                count += 1;
            } else {
                count = 1;
            }

            if (count <= 2) {
                left += 1;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}


//////////////////////////////////////////////
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                if (count < 2) {
                    j++;
                    nums[j] = nums[i];
                    count++;
                }
            } else {
                j++;
                nums[j] = nums[i];
                count = 1;
            }
        }
        return j + 1;
    }
}
