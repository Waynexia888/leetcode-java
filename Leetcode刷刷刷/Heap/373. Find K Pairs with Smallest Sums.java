// You are given two integer arrays nums1 and nums2 sorted in ascending order and 
// an integer k.

// Define a pair (u,v) which consists of one element from the first array and 
// one element from the second array.

// Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

// Example 1:

// Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
// Output: [[1,2],[1,4],[1,6]] 
// Explanation: The first 3 pairs are returned from the sequence: 
//              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// Example 2:

// Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
// Output: [1,1],[1,1]
// Explanation: The first 2 pairs are returned from the sequence: 
//              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// Example 3:

// Input: nums1 = [1,2], nums2 = [3], k = 3
// Output: [1,3],[2,3]
// Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]



class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return results;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        // pq里面存入k个pairs， k可能比nums1.length大，也可能比它小
        // eg: nums1 = [1, 7, 11]; nums2 = [2, 4, 6]; k = 2
        // results = [[1, 2], [7, 2]], [1, 2]肯定是最小的， 因为nums1和nums2都是排序的
        for (int i = 0; i < k && i < nums1.length; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        // 从pq里poll出k次, 每poll一次，需要offer一次，因为[1, 2]是最小的， 但是[7, 2]不一定是第二小的
        while (!pq.isEmpty() && k-- > 0) {
            int[] pairs = pq.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(pairs[0]);
            temp.add(pairs[1]);
            results.add(temp);
            
            if (pairs[2] == nums2.length - 1) {
                continue;
            }
            // 这里offer的是[1, 4]
            pq.offer(new int[]{pairs[0], nums2[pairs[2] + 1], pairs[2] + 1});
        }
        return results;
    }
}

// 本题思想： 找第k小的pairs
// 当然是用堆（优先队列），按照pairs的sum，从小到大排序
// 举一个例子：nums1 = [1, 7, 11]; nums2 = [2, 4, 6]; k = 3
// 我们不可能把nums1 + nums2 的所有元素组成pairs，都存入堆里，因为效率不高
// 因此考虑在优先队列里存入k个pairs
// 可以考虑先把nums1的所有元素 + nums2里ndex = 0的那个元素，组成pairs 存入到优先队列里
// 即results = [[1, 2], [7, 2], [11, 2]], [1, 2]肯定是最小的， 因为nums1和nums2都是排序的
// 然后写一个while loop， 每poll一个pair出来，存入在results结果集中，同时offer一个新的pair进入优先队列中
// 时间复杂度: O(klogk), k is the given input
// 空间复杂度: O(k), 因为堆里面最多存k个pairs