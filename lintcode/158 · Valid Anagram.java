public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // using hashmap, time: O(n) space: O(n)
        // key: char; value: count 
        Map<Character, Integer> map = new HashMap<>();

        // s = "ac" 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
   
            map.put(c, map.getOrDefault(c, 0) + 1); 
        }
        // map = {"a": 0, "c": -1}

        // t = "acc"
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}

/////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // using int[] instead of using hashmap
        // time: O(n); space: O(1)
        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : t.toCharArray()) {
            count[c]--;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}