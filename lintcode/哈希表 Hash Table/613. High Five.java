/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // hashmap: key: Integer -> id; value: PriorityQueue -> score
        
        Map<Integer, Double> map = new HashMap<>();
        if (results == null || results.length == 0) {
            return map;
        }
        
        Map<Integer, PriorityQueue<Integer>> hashmap = new HashMap<>();
        for (Record r : results) {
            if (!hashmap.containsKey(r.id)) {
                hashmap.put(r.id, new PriorityQueue<>());
            }
            PriorityQueue<Integer> minHeap = hashmap.get(r.id);
            if (minHeap.size() < 5) {
                minHeap.offer(r.score);
            } else {    // >= 5
                if (minHeap.peek() < r.score) {
                    minHeap.poll();
                    minHeap.offer(r.score);
                }
            }
        }
        
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : hashmap.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            double total = 0;
            for (int i = 0; i < 5; i++) {
                total += scores.poll();
            }
            double average = total / 5.0;
            map.put(id, average);
        }
        return map;
    }
}