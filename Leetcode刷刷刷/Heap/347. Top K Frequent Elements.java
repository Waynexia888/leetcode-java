// Given a non-empty array of integers, return the k most frequent elements.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]

// Note:

// 1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// 2. Your algorithm's time complexity must be better than O(n log n), where n is 
//     the array's size.
// 3. It's guaranteed that the answer is unique, in other words the set of the top 
//     k frequent elements is unique.
// 4. You can return the answer in any order.



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
       
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }
        
        int[] results = new int[k];
        int index = 0;
        while (index < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            results[index++] = entry.getKey();
        }
        return results;
    }
}

// 本题思路： 优先队列 + hashmap
// 使用优先队列求数组中数字出现频率最高的k个数字
// hashmap来存储每个数字->出现的频率
// 优先队列保存的是Map.Entry<>这种结构，建立一个最大堆
// 时间复杂度: O(klogn);
// 空间复杂度: O(n)