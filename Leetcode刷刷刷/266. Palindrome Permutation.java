// time: O(n); space: O(n)
class Solution {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
}


// time: O(n), space: O(1)

class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] count = new char[256];
        
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
            } else {
                count[c]++;
            }
        }
        
        int result = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                result++;
            }
        }
        return result <= 1;
    }
}


