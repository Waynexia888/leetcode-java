public class Solution {
    /*
     * @param str: A string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // time:o(n), space: o(n)
        if (str == null || str.length() == 0) {
            return true;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (Character key : map.keySet()) {
            if (map.get(key) > 1) {
                return false;
            }
        }
        return true;
    }
}

//////////////////////////////////////////
public class Solution {
    /*
     * @param str: A string
     * 
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // time:o(n^2), space: o(1)
        if (str == null || str.length() == 0) {
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j < str.length(); j++) {
                if (j > i && str.charAt(j) == str.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}