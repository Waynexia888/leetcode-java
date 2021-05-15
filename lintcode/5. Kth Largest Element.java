public class Kth_Largest_Element {
    /**
     * @param n:    An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        // quick select 算法
        // (平均)时间复杂度：O(n), 空间复杂度O(1)
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        // partition 分割步骤
        int left = start, right = end;
        int pivot = nums[(left + right) / 2];
        while (left <= right) {
            // 因为是从大到小排放
            while (left <= right && nums[left] > pivot) {
                left++;
            }

            while (left <= right && nums[right] < pivot) {
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

        // 当上述while结束，即left > right, 即left在right右边，此时nums被划分为3块，
        // [start,.......right, x, left, .......,end]

        // 当在左半部分的时候
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        // 当在右半部分的时候，左半部分的数可以不用看了，
        // 那么左边有几个数呢？ (left - start)个数
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }

        // 当在最中间那一个数的时候，直接return如下：
        return nums[right + 1];
    }
}


/////////////////////////////////////////////////

public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (a - b));   // k size
        for (int num : nums) {
            maxHeap.offer(num);
        }

        while (maxHeap.size() > n) { 
            maxHeap.poll();
        }
        return maxHeap.poll();
    }
}

// time: O(nlog(n));
// space: O(n), where n is your size

/////////////////////////////////////////////////
public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();   // k size
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > n) { 
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}

// time: O(nlog(k));
// space: O(k), where n is your size


////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[end];
        }

        int left = start, right = end;
        int pivot = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
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
        if (k >= start && k <= right) {
            return quickSelect(nums, start, right, k);
        }

        if (k >= left && k <= end) {
            return quickSelect(nums, left, end, k);
        }
        
        
        return nums[right + 1];
    }
}








