public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        return quickselect(k, nums, 0, nums.length - 1);
    }
    
    private int quickselect(int k, int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        
        int left = start, right = end;
        int pivot = nums[(start + end) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
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
        
        // from smallest to largest
        // right > left
        // [start, ..., right, x, left, ... end]
        if (start + k - 1 <= right) {
            return quickselect(k, nums, start, right);
        }
        if (start + k - 1 >= left) {
            return quickselect(k - (left - start), nums, left, end);
        }
        return nums[right + 1];
        
    }
}

// [3, 4, 1, 2, 5] pivot = 1 
//  L           R 
 
// [3, 4, 1, 2, 5] 
//  L     R 
 

// [1, 4, 3, 2, 5] 
//     L  
//     R 
    
// [1, 4, 3, 2, 5] 
//     L  
//  R 


//////////////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param k:    An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // 维持一个size为k的最大堆
        // time: O(nlogk)
        if (nums == null || nums.length == 0 || k < 0) {
            return -1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (Integer number : nums) {
            maxHeap.offer(number);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}