public class Fizz_Buzz {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public ArrayList<String> fizzBuzz(int n) {
        // write your code here
        ArrayList<String> results = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results.add("fizz buzz");
            } else if (i % 3 == 0) {
                results.add("fizz");
            } else if (i % 5 == 0) {
                results.add("buzz");
            } else {
                results.add(String.valueOf(i)); // i + ""
            }
        }

        return results;
    }
}

////
// int to String -> String.valueOf(int x)
// string to int -> Integer.parseInt(string x)