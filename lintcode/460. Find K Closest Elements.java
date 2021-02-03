public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // 找到分界线，确定left和right的位置
        // 找到 A[left] < target, A[right] >= target
        // 也就是最接近target的两个数， 他们肯定是相邻的
        int right = findUpperClosest(A, target);
        int left = right - 1;
        
        // 背向双指针, 两根指针从中间往两边扩展，依次找到最接近的 k个数
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, target, left, right)) {
                results[i] = A[left];
                left--;
            } else {
                results[i] = A[right];
                right++;
            }
        }
        return results;
    }
    
    private boolean isLeftCloser(int[] A, int target, int left, int right) {
        // 如果左指针出界，那就取右指针
        if (left < 0) {
            return false;
        }
        
        // 如果右指针出界，那就取左指针
        if (right >= A.length) {
            return true;
        }
        
        // 如果两根指针都在范围内，比较谁更接近target
        // 注意等于的情况取 左边的，因为左边的一定比右边的要小（题目要求）
        if ((target - A[left]) <= (A[right] - target)) {
            return true;
        }
        return false;
    }
    
    
    private int findUpperClosest(int[] A, int target) {
        // find the first number >= target, 套用 14. First Position of Target 模版
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (A[start] >= target) {
            return start;
        }
        
        if (A[end] >= target) {
            return end;
        }
        // 如果找不到一个数>= target, 就让right = A.length
        return A.length;
    }
}