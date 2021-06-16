692. Top K Frequent Words

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(); // time: O(n); space: O(n)
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                int val1 = e1.getValue();
                int val2 = e2.getValue();
                if (val1 == val2) {
                    return e2.getKey().compareTo(e1.getKey()); // decreasing order by alphabetical, String比较用compareTo()
                } 
                return e1.getValue() - e2.getValue(); // ascending order by value
            }
        });
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) { // time: O(n * logk); space: O(n)
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        List<String> results = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            results.add(0, minHeap.poll().getKey());
        }
        return results;
    }
}
