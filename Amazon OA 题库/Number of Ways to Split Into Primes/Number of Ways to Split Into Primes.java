import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public static int splitPrimes(String inputStr) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //  Set<Integer> set = new HashSet<>();
        dfs(inputStr,temp, results);
        return results.size();
    }
    
    private static void dfs(String inputStr, List<Integer> temp, List<List<Integer>> results) {
        if (inputStr.length() == 0) {
            results.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < inputStr.length(); i++) {
            String s = inputStr.substring(0, i + 1);
            int number = Integer.parseInt(s);
            if (isPrimeNumber(number)) {
                temp.add(number);
                
                dfs(inputStr.substring(i + 1),temp, results);
                temp.remove(temp.size() - 1);
                
            }
        }
        
    }
    
    private static boolean isPrimeNumber(int number) {
        Set<Integer> map = new HashSet<>();
	    if (map.contains(number)) {
            return true;
	    }
	    boolean isPrime = isPrime(number);
	    if(isPrime) map.add(number);
	
	    return isPrime;
    }
    
    private static boolean isPrime(int number) {
        if ((number + "").charAt(0) == '0') {
            return false;
        }
        
        if (number > 1000) {
            return false;
        }
        
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        scanner.close();
        int res = splitPrimes(inputStr);
        System.out.println(res);
    }
}
