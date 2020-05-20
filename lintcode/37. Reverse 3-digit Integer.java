public class Reverse_3_digit_Integer {
    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        // write your code here
        // 123 -> 321
        // 321 -> 3 * 100 + 2 * 10 + 1
        // 123 -> 取出个位数

        int a = number % 10; // 3
        int b = number / 10 % 10; // 2
        int c = number / 100 % 10; // 1
        return a * 100 + b * 10 + c;

    }
}