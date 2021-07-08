class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // time: O(26n + m) ~= O(n); space: O(1)
        List<Integer> results = new ArrayList<>();
        int[] pHash = new int[26];
        int[] sHash = new int[26];
        
        // count the frequency of each char in String p, time: O(m)
        for (char c : p.toCharArray()) {
            pHash[c - 'a']++;
        }
        
        // two pointer, same direction, take O(26n) time
        int j = 0;
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            while (j < s.length() && j - i + 1 <= p.length() && !isAnagram(sHash, pHash)) {
                sHash[s.charAt(j) - 'a']++;
                j++;
            }
            if (j - i == p.length() && isAnagram(sHash, pHash)) {
                results.add(i);
            }
            sHash[s.charAt(i) - 'a']--;
        }
        return results;
    }
    
    private boolean isAnagram(int[] sHash, int[] pHash) {  
        for (int i = 0; i < 26; i++) {
            if (pHash[i] != sHash[i]) {
                return false;
            }
        }
        return true;
    }
}

// sHash = {}
// i = 0, j = 0; 0 - 0 + 1 = 1 <= 2; sHash = {'a'}, j = 1

// i = 0, j = 1; 1 - 0 + 1 = 2 <= 2; sHash = {'a', 'b'}, j = 2

// sHash = {'b'}
// i = 1, j = 2, 2 - 1 + 1 = 2 <= 2; sHash = {'b', 'a'}, j = 3
// 3 - 1 = 2 == 2

