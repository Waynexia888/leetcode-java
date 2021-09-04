Leetcode 179. Largest Number

class Solution {
    public String largestNumber(int[] nums) {
        // time: O(nlogn); space: O(n)
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        // sort the arr in decresing order
        Arrays.sort(arr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        
        // 如果第一个数是0， 后面的数肯定比0 小 或等于； eg: [0, 0] -> return "0"
        if (arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}