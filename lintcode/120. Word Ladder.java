public class Solution {
    /*
     * @param start: a string
     * 
     * @param end: a string
     * 
     * @param dict: a set of string
     * 
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // BFS模版 + 构建新的单词
        if (start == null || end == null || dict == null) {
            return 0;
        }

        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        // Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        queue.offer(start);
        // set.add(start);
        map.put(start, 1);

        // int distance = 0;
        while (!queue.isEmpty()) {
            // distance++;
            // int size = queue.size();
            // for (int i = 0; i < size; i++) {
            String word = queue.poll();
            if (word.equals(end)) {
                return map.get(word);
            }

            for (String w : getNextWord(word)) {
                // if (set.contains(w) || !dict.contains(w)) {
                // continue;
                // }
                if (map.containsKey(w) || !dict.contains(w)) {
                    continue;
                }

                queue.offer(w);
                // set.add(w);
                map.put(w, map.get(word) + 1);
            }
            // }
        }
        return 0;
    }

    // 根据一个单词，构建出其余25种新的单词，把它们放入一个数组中;
    // 单词的length L, 时间复杂度: O(25 * L^2)
    private ArrayList<String> getNextWord(String word) {
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) { // O(L)
            for (char c = 'a'; c <= 'z'; c++) { // O(25)
                if (c == word.charAt(i)) {
                    continue;
                }
                String newWord = replace(word, i, c); // O(L)
                words.add(newWord);
            }
        }
        return words;
    }

    private String replace(String word, int index, char c) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}