public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // time: O(n * nlogn); space: O(n)
        List<String> results = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return results;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);  // ['i', 'l', 'n', 't']
            String s = new String(arr);  // "ilnt"
            // String s = String.valueOf(arr);
            map.put(s, map.getOrDefault(s, 0) + 1);
            // {"ilnt": 3, "cdeo": 1}
        }

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);  
            String s = new String(arr);  
            if (map.get(s) > 1) {
                results.add(strs[i]);
            }
        }
        return results;
    }
}

