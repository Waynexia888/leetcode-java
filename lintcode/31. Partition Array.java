public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] < k) {
                left++;
            }
            while (left <= right && nums[right] >= k) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;  // or: return right + 1;
    }
}

// [3, 2, 2, 1]
//  L        R
 
// [1, 2, 2, 3]
//     L  R
    
// [1, 2, 2, 3]
//     L        
//     R

// [1, 2, 2, 3]
//     L        
//  R

// [3, 2, 1]
//  L     R
 
// [1, 2, 3]
//     L     
//     R
    
// [1, 2, 3]
//     L     
//  R


/////////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] < k) {
                left++;
            } 

            while (left <= right && nums[right] >= k) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        // if (nums[left] < k) {
        //     return left + 1;
        // }
        return left;
    }
}

// 1 2 2 3
//   L
// R 
