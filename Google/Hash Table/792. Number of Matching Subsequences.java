Leetcode 792. Number of Matching Subsequences

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // map: key -> character; value -> an arraylist that contains all string that start with this character/key
        Map<Character, List<String>> char2List = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if (!char2List.containsKey(c)) {
            //     char2List.put(c, new ArrayList<>());
            // }
            char2List.putIfAbsent(c, new ArrayList<>());
        }
        
        for (String word : words) {
            char startChar = word.charAt(0);
            if (char2List.containsKey(startChar)) {
                char2List.get(startChar).add(word);
            }
        }
        
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char startChar = s.charAt(i);
            List<String> list = char2List.get(startChar);
            for (int k = 0; k < list.size(); i++) {
                String ss = list.get(k);
                if (ss.substring(1).length() == 0) {
                    ans++;
                } else {
                    char nextChar = ss.charAt(1);
                    if (char2List.containsKey(nextChar)) {
                        char2List.get(nextChar).add(ss.substring(1));
                    }
                }
            }
        }
        return ans;
    }
}

// ans = 0;
// map = { 
// "a": {"a", "acd", "ace"}
// "b": {"bb"}
// "c": {}
// "d": {}
// "e": {}
// }

// ans = 0 + 1 = 1
// map = {
// "a": {}
// "b": {"bb"}
// "c": {"cd", "ce"}
// "d": {}
// "e": {}
// }

// ans = 0 + 1 = 1
// map = {
// "a": {}
// "b": {"b"}
// "c": {"cd", "ce"}
// "d": {}
// "e": {}
// }

// ans = 0 + 1 = 1
// map = {
// "a": {}
// "b": {"b"}
// "c": {}
// "d": {"d"}
// "e": {"e"}
// }

// ans = 0 + 1 = 1 + 1 = 2
// map = {
// "a": {}
// "b": {"b"}
// "c": {}
// "d": {}
// "e": {"e"}
// }

// ans = 0 + 1 = 1 + 1 = 2 + 1 = 3
// map = {
// "a": {}
// "b": {"b"}
// "c": {}
// "d": {}
// "e": {}
// }
