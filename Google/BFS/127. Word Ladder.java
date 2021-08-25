Leetcode 127. Word Ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // time: O(25 * L^2 * n), where n is the size of wordList
        // space: O(n * L) L is the length of word
        Set<String> dict = new HashSet<>();  // O(n) space, where n is the size of wordList
        dict.addAll(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();
        queue.offer(beginWord);
        distance.put(beginWord, 1);
        
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word.equals(endWord)) {
                // return distance.get(word);
                break;
            }
            
            List<String> list = getWordList(word, dict);
            for (String w : list) {
                if (!distance.containsKey(w)) {
                    queue.offer(w);
                    distance.put(w, distance.get(word) + 1);
                }
            }
        }
        return distance.getOrDefault(endWord, 0);
        // return 0;
    }
    
    // O(25* L^ 2) where L is the length of word
    private List<String> getWordList(String word, Set<String> dict) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) { // O(L)
            for (char c = 'a'; c <= 'z'; c++) { // O(25)
                if (word.charAt(i) == c) { // O(L)
                    continue;
                }
                char[] arr = word.toCharArray();
                arr[i] = c;
                String newWord = new String(arr);
                if (dict.contains(newWord)) {
                    results.add(newWord);
                }
            }
        }
        return results;
    }
}

// put beginWord into queue, map

// for every char in the beginWord,  O(L)
//     we can switch it to other 25 characters O(25)
//         make it to a new word, and make sure wordList contains the new word O(L)
        
