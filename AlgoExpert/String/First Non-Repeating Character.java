import java.util.*;

class Program {

  public int firstNonRepeatingCharacter(String string) {
    // Write your code here.
		char[] arr = string.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			int j = 0;
			
			if (i == j) {
				j++;
			}
			
			while (j < arr.length && arr[i] != arr[j]) {
				j++;
				if (i == j) {
					j++;
				}
			}
			
			if (j == arr.length) {
				return i;
			}
			
		}
    return -1;
  }
}


// same direction two pointers
// ['a', 'b', 'c', 'd', 'c', 'a', 'f']
//        i
// 	                                    j

/////////////////////////////////////////////////////////////////////
import java.util.*;

class Program {

  public int firstNonRepeatingCharacter(String string) {
    //time: O(n); space: O(n)
		char[] arr = string.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (map.get(c) == 1) {
				return i;
			}
		}
		
    return -1;
  }
}

