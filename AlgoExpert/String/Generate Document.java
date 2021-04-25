import java.util.*;

class Program {

  public boolean generateDocument(String characters, String document) {
    // Write your code here.
		int[] availableChars = new int[256];
		int[] documentChars = new int[256];
		char[] ch = characters.toCharArray();
		char[] d = document.toCharArray();
		
		for (Character c : ch) {
			availableChars[c]++;
		}
		
		for (Character c : d) {
			documentChars[c]++;
		}
		
		for (int i = 0; i < 256; i++) {
			if (availableChars[i] < documentChars[i]) {
				return false;
			}
		}
    return true;
  }
}

// 1. store the frequency of every unique characters in the character string to the array1;
// 2. store the frequency of every unique characters in the document string to the array2;
// 3. iterate the array1, and compare their frequency