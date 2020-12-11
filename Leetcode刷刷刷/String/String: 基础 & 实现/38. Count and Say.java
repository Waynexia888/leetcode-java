class Solution {
    public String countAndSay(int n) {
        String result = "1";
        if (n == 1) return result;
        
        for (int i = 2; i <= n; i++) {
            result = helper(result);
        }
        
        return result;
    }
    
    private String helper(String res) {
        char c = res.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < res.length(); i++) {
            if (res.charAt(i) != c) {
                sb.append(count);
                sb.append(c);
                c = res.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }
}
