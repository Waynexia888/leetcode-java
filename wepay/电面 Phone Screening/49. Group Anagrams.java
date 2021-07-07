class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // approach 1: using hashmap, key is the sorted string, 
        // value is the list of strings from the initial input that when sorted, are equal to key
        // time: O(n * klog(k)) where n is the length of strs, and k is the maximum length of a string in strs
        // space: O(n * k)
        List<List<String>> results = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return results;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}