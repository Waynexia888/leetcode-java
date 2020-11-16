class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}


// a=b. If both the strings are identical, it is obvious that no 
// subsequence will be uncommon. Hence, return -1.

// length(a)=length(b) and a not equal b 
// Example: abc and abd. In this case we can consider any string 
// i.e. abc or abd as a required subsequence, as out of these two
// strings one string will never be a subsequence of other string. 
// Hence, return length(a)length(a) or length(b)length(b).

// length(a) not equal length(b)
// Example abcd and abc. In this case we can consider bigger string 
// as a required subsequence because bigger string can't be a 
// subsequence of smaller string. Hence, return max(length(a),
// length(b)).