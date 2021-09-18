Leetcode 1525. Number of Good Ways to Split a String

class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> secondPartMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            secondPartMap.put(c, secondPartMap.getOrDefault(c, 0) + 1);
        }
        
        int numOfGoodWays = 0;
        Map<Character, Integer> firstPartMap = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            firstPartMap.put(c, firstPartMap.getOrDefault(c, 0) + 1);
            if (secondPartMap.get(c) > 1) {
                secondPartMap.put(c, secondPartMap.get(c) - 1);
            } else {
                secondPartMap.remove(c);
            }
            if (firstPartMap.size() == secondPartMap.size()) {
                numOfGoodWays++;
            }
        }
        return numOfGoodWays;
    }
}

// time: O(n); space: O(n)