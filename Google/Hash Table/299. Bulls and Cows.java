Leetcode 299. Bulls and Cows

class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (char c : secret.toCharArray()) {
            charToCount.put(c, charToCount.getOrDefault(c, 0) + 1);
        }
        
        int bulls = 0, cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (!charToCount.containsKey(c)) {
                continue;
            } else {
                if (c == secret.charAt(i)) {
                    bulls++;
                    if (charToCount.get(c) <= 0) {
                        cows--;
                    }
                } else {  // !=
                    if (charToCount.get(c) > 0) {
                        cows++;
                    }
                }
                charToCount.put(c, charToCount.get(c) - 1); 
            }
        }
        // return bulls + "" + "A" + cows + ""+ "B";
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}


// 1 1 2 3 {1:0, 2: 1, 3: 1}
    
// 0 1 1 1
//       i 

// bulls: 1 
// cows: 1

// Map<Character, Integer> 
// char -> count

// Integer.toString()

// time: O(n), 
// space: O(1), hashmap which contains at most 10 elements

//////////////////////////////////////////////////////////////

