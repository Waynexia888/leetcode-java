// You want to build yourself a house. The building company you hired can only 
// build houses with sides from their specific set s. That means they can build 
// you a square house or a rectangular one but if and only if its len gth and 
// width belongs to the set s.

// this month, they have a specific promotion: they will paint the ceiling of 
// a new house for free..but only if its area is not more than a. You want them 
// to do it for free but you also want to be sure that the house will be 
// comfortable and not too small. How many possible house configuations can you
// create to have the ceiling painted for free given the side lengths offered?

// there is a method to how the company decides what lengths of sides to produce.
// To determine n lengths of wall segements to offer, they start with a seed value
// s0, some variables k, b, and m, and use the following equation to determine all
// other side lengths s[i]:
// s[i] = ((k * s[i - 1] + b) % m) + 1 + s[i - 1] for 1 <= i < n 


// for example, you are given s[0] = s0 = 2 and they will produce n = 3 total wall
// lengths. If k = 3, b = 3, and m = 2 we have:
// s           i       calculation                 result
// [2]         1       ((3 * 2 + 3) % 2) + 1 + 2     4
// [2, 4]      2       ((3 * 4 + 3) % 2) + 1 + 4     6
// [2, 4, 6]

// now that we have our set of lengths, we can brute force the solution using the 
// following tests assuming a = 15;
// s = [2, 4, 6]

// s1     s2       s1 * s2         s1 * s2 <= a
// 2      2          4                True
// 2      4          8                True
// 2      6          12               True
// 4      2          8                True
// 4      4          16               False
// 4      6          24               False
// 6      2          12               True
// 6      4          24               False
// 6      6          36               False

// There are 5 combinations that will result in a free paint job.
// Brute force will not meet the time constraints on large sets.


// complete the function variantsCount. The function must return an integer that
// denotes the number of variants that allow you to use the promotion. 


public static long variantsCount(int n, int s0, int k, int b, int m, long a) {
    long[] s = new long[n];
    s[0] = s0;
    for (int i = 1; i < n; i++) {
        s[i] = (long)((k * s[i - 1] + b) % m) + 1 + s[i - 1];
    }
    long count = 0;
    int i = 0;
    int j = n - 1;
    while (i <= j) {
        if (s[i] * s[j] <= a) {
            count += ((j - i) * 2 + 1);
            i++; 
        } else {
            j--;
        }
    }
    return count;
}


// https://leetcode.com/discuss/interview-question/853151/Roblox-New-Grad-Online-Assessment-Questions