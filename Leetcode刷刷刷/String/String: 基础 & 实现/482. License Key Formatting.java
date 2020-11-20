class Solution {
    public String licenseKeyFormatting(String S, int K) {
        // time: O(n); space: O(n)
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                sb.append(sb.length() % (K + 1) == K ? '-' : "");
                sb.append(S.charAt(i));
                System.out.println(sb);
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}