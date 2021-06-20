class Solution {
    class Product {
        public int fiveStarReviews;
        public int totalReviews;
        public double rating;
        public double increasing;

        public Product(int fiveStarReviews, int totalReviews) {
            this.fiveStarReviews = fiveStarReviews;
            this.totalReviews = totalReviews;
            this.rating = (double)(fiveStarReviews / totalReviews);
            this.increasing = (double)(fiveStarReviews + 1) / (totalReviews + 1) - this.rating;
        }
    }

    public static int fiveStarReviews(List<List<Integer>> ratings, int threshold) {
        int productCount = ratings.size();
        PriorityQueue<Product> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.increasing, a.increasing));
        double currentPercentage = 0;
        for (List<Integer> list : ratings) {
            int first = list.get(0);
            int second = list.get(1);
            maxHeap.offer(new Product(first, second));
            currentPercentage += (double) first / second;
        }
        currentPercentage / = count;

        // int count = 0;
        // while (currentPercentage * 100 < threshold) {
        //     Product temp = maxHeap.poll();
        //     currentPercentage += temp.increasing / productCount;
        //     temp = new Product(temp.fiveStarReviews + 1, temp.totalReviews + 1);
        //     maxHeap.offer(temp);
        //     count++;
        // }
        // return count;
        double diff = threshold / 100.0 - currentPercentage;
        int count = 0;
        while (diff > 0) {
            Product temp = maxHeap.poll();
            diff -= temp.increasing / productCount;
            maxHeap.offer(temp.fiveStarReviews + 1, temp.totalReviews + 1);
            count++;
        }
        return count;
    }
}

