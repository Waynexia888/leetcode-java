public class Solution {
    /**
     * @param s: The string s
     * @param excludeList: The excludeList
     * @return: Return the most frequent words
     */
    public List<String> getWords(String s, String[] excludeList) {
        // Write your code here
        Set<String> set = new HashSet<>();
        for (String str : excludeList) {
            set.add(str.toLowerCase());
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isLetter(s.charAt(j))) {
                    j++;
                }
                String str = s.substring(i, j).toLowerCase();
                if (!set.contains(str)) {
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
                i = j - 1;
            }
        }

        List<String> list = new ArrayList<>();
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            } else if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);
        return list;
    }
}

// "I love Amazon."
//        i
//        j
//     用哈希表统计每个不在excludeList数组中出现的单词的出现次数，
//     然后遍历这哈希表，把出现次数最高的单词存起来，最后排一个序