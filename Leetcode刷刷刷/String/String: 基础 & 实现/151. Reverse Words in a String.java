class Solution {
    public String reverseWords(String s) {
        // time: O(n); space: O(n)
        s = s.trim();
        String[] arr = s.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i] + " ");
        }
        return sb.toString().trim();
    }
}