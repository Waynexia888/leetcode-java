class Average {
    public double pass;
    public double total;
    public double rate;
    public double increasing;
    public Average(double pass, double total) {
        this.pass = pass;
        this.total = total;
        this.rate = pass / total;
        this.increasing = (pass + 1.0) / (total + 1.0) - this.rate;
    }
}

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int classSize = classes.length;
        PriorityQueue<Average> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.increasing, a.increasing));
        
        for (int[] c : classes) {
            maxHeap.offer(new Average(c[0] * 1.0, c[1] * 1.0));
        }
        
        while (extraStudents > 0) {
            Average temp = maxHeap.poll();
            maxHeap.offer(new Average(temp.pass + 1.0, temp.total + 1.0));
            extraStudents--;
        }
        
        double res = 0;
        while (!maxHeap.isEmpty()) {
            res += maxHeap.poll().rate;
        }
        return res / classSize;
        
    }
}

//            0.0834
// maxHeap = {0.16, 0.06666, 0}
// [1, 2], [3, 5], [2, 2] = 0.7
// [2, 3], [3, 5], [2, 2] = 0.7555
// [3, 5], [3, 4], [2, 2] = 0.78333