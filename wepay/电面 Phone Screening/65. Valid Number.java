class Solution {
    public boolean isNumber(String s) {
        boolean firstPart = false;
        boolean secondPart = false;
        boolean hasDot = false;
        boolean hasE = false;
        
        int index = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            index++;
        }
        
        while (index < s.length()) {
            char c = s.charAt(index);
            // +6e-1, 3e+7, --6, -+3
            if (c == '+' || c == '-') {
                if (s.charAt(index - 1) != 'e' && s.charAt(index - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // -6.6.6e8.8, 99e2.5
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (c == 'e' || c == 'E') { //e3, 1e
                if (hasE || !firstPart) {
                    return false;
                }
                hasE = true;
            } else if (Character.isDigit(c)) {
                if (hasE) {
                    secondPart = true;
                } else {
                    firstPart = true;
                }
            } else { // !Character.isDigit(c), 1a, abc
                return false;
            }
            index++;
        }
        
        return (firstPart) && ((!hasE && !secondPart) || (hasE && secondPart));
    }
}

// -6e93
// -6.6e93
// second part must be an integer, so check digit character? any dot? any sign?
// check sign character before checking first part?
// first part is a decimal number
//     if only one dot:
//         return true
//     else 
//         return false
// first part is an integer
//     first part = true
    
    
    