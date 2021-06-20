class Distance {
    int x, y;
    double distance;
    public Distance(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt(x * x * 1.0 + y * y * 1.0);
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Distance> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a.distance, b.distance));
        for (int[] point : points) {
            minHeap.offer(new Distance(point[0], point[1]));
        }
        
        int[][] results = new int[k][2];
        while (k > 0) {
            Distance d = minHeap.poll();
            results[k - 1][0] = d.x;
            results[k - 1][1] = d.y;
            k--;
        }
        return results;
    }
}

time: O(n + k * logn)
space: O(n)