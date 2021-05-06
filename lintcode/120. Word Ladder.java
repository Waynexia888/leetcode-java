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

////////////////////////////////////////////////////////////////////////////////////

public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        // BFS + 构建新的单词
        if (start == null || end == null || dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(start);
        set.add(start);

        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String  currentWord = queue.poll();
                if (currentWord.equals(end)) {
                    return distance;
                }

                for (String word : getWords(currentWord, dict)) {
                    if (!set.contains(word)) {
                        queue.add(word);
                        set.add(word);
                    }
                }
            }
        }
        return distance;
    }

    private List<String> getWords(String word, Set<String> dict) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (word.charAt(i) == c) {
                    continue;
                }
                // 构造一个新的字符串
                char[] chars = word.toCharArray();
                chars[i] = c;
                String temp = new String(chars);

                if (dict.contains(temp)) {
                    results.add(temp);
                }
            }
        }
        return results;
    }
}

//////////////////////////////////////////////////////////////
public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        
        dict.add(start);
        dict.add(end);

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(start);
        set.add(start);

        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (s.equals(end)) {
                    return res;
                }
                List<String> list = getWords(s, dict);
                for (String word : list) {
                    if (!set.contains(word)) {
                        queue.offer(word);
                        set.add(word);
                    }
                }
            }
        }
        return res;
    }

    private List<String> getWords(String s, Set<String> dict) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (s.charAt(i) == c) {
                    continue;
                }
                char[] arr = s.toCharArray();
                arr[i] = c;
                String temp = new String(arr);

                if (dict.contains(temp)) {
                    results.add(temp);
                }
            }
        }
        return results;
    }
}
// "hit", dict =["hot","dot","dog","lot","log", "dot", "cot"]
// ["hot", "dot", "cot"]
