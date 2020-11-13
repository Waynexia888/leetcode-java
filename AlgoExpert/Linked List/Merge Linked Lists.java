import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
    // time: O(n + m) where n is the number of node in headOne
		// space: O(1)
		LinkedList dummy = new LinkedList(-1);
		LinkedList cur = dummy;
		LinkedList p1 = headOne;
		LinkedList p2 = headTwo;
		
		while (p1 != null && p2 != null) {
			if (p1.value <= p2.value) {
				cur.next = p1;
				p1 = p1.next;
			} else {
				cur.next = p2;
				p2 = p2.next;
			}
			cur = cur.next;
		}
		
		if (p1 != null) {
			cur.next = p1;
		}
		
		if (p2 != null) {
			cur.next = p2;
		}
    return dummy.next;
  }
}
