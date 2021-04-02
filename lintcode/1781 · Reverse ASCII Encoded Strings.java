public class Solution {
    /**
     * @param encodeString: an encode string
     * @return: a reversed decoded string
     */
    public String reverseAsciiEncodedString(String encodeString) {
        // Write your code here
        if (encodeString == null || encodeString.length() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        // String s = new String();
        for (int i = encodeString.length() - 1; i > 0; i -= 2) {
            int number = (encodeString.charAt(i - 1) - '0') * 10 + (encodeString.charAt(i) - '0');
            sb.append((char)number);
            // s += (char)number;
        }
        return sb.toString();
        // return s;
    }
}

// '7' - '0' = 7 * 10  = 70 + ('2' - '0') = 72