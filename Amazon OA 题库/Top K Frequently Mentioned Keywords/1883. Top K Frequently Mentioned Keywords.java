public class Solution {
    /**
     * @param K: a integer
     * @param keywords: a list of string
     * @param reviews: a list of string
     * @return: return the top k keywords list
     */
    public List<String> TopkKeywords(int K, String[] keywords, String[] reviews) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (keywords == null || keywords.length == 0 || reviews == null || reviews.length == 0) {
            return results;
        }

        for (int i = 0; i < reviews.length; i++) {
            String review = reviews[i];
            review = review.replaceAll("[\\!?,;.&]", "").toLowerCase();
            review = review.replace("[", "");
            review = review.replace("]", "");
            review = review.toLowerCase();
            reviews[i] = " " + review + " ";
        }

        // O(n ^ 2)
        Map<String, Integer> map = new HashMap<>();
        for (String keyword : keywords) {
            for (String review : reviews) {
                if (review.contains(" " + keyword.toLowerCase() + " ")) {
                    map.put(keyword, map.getOrDefault(keyword, 0) + 1);
                }
            }
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>(
            (a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a)
        );

        for (String key : map.keySet()) {
            maxHeap.offer(key);
        }

        while (K > 0) {
            String s = maxHeap.poll();
            if (s != null) {
                results.add(s);
            }
            K--;
        }
        return results;
    }
}

////////////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param K: a integer
     * @param keywords: a list of string
     * @param reviews: a list of string
     * @return: return the top k keywords list
     */
    public List<String> TopkKeywords(int K, String[] keywords, String[] reviews) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (keywords == null || keywords.length == 0 || reviews == null || reviews.length == 0) {
            return results;
        }

        for (int i = 0; i < reviews.length; i++) {
            String review = reviews[i];
            review = review.replaceAll("[\\!?,;.&]", "").toLowerCase();
            review = review.replace("[", "");
            review = review.replace("]", "");
            review = review.toLowerCase();
            reviews[i] = " " + review + " ";
        }

        // O(n ^ 2)
        Map<String, Integer> map = new HashMap<>();
        for (String keyword : keywords) {
            for (String review : reviews) {
                if (review.contains(" " + keyword.toLowerCase() + " ")) {
                    map.put(keyword, map.getOrDefault(keyword, 0) + 1);
                }
            }
        }
        
        // minHeap
        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b)
        );

        for (String key : map.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            String s = minHeap.poll();
            if (s != null) {
                results.add(0, s);
            }
            K--;
        }
        return results;
    }
}

///////////////////////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param K: a integer
     * @param keywords: a list of string
     * @param reviews: a list of string
     * @return: return the top k keywords list
     */
    public List<String> TopkKeywords(int K, String[] keywords, String[] reviews) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (keywords == null || keywords.length == 0 || reviews == null || reviews.length == 0) {
            return results;
        }

        for (int i = 0; i < reviews.length; i++) {
            String review = reviews[i];
            review = review.replaceAll("[\\!?,;.&]", "").toLowerCase();
            review = review.replace("[", "");
            review = review.replace("]", "");
            review = review.toLowerCase();
            reviews[i] = " " + review + " ";
        }

        // O(n ^ 2)
        Map<String, Integer> map = new HashMap<>();
        for (String keyword : keywords) {
            for (String review : reviews) {
                if (review.contains(" " + keyword.toLowerCase() + " ")) {
                    map.put(keyword, map.getOrDefault(keyword, 0) + 1);
                }
            }
        }
        
        // minHeap
        PriorityQueue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (map.get(a) == map.get(b)) {
                    return b.compareTo(a);
                }
                return map.get(a) - map.get(b);
            }
        });

        for (String key : map.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            String s = minHeap.poll();
            if (s != null) {
                results.add(0, s);
            }
            K--;
        }
        return results;
    }
}