import java.util.*;

class Program {
  public static LinkedList findLoop(LinkedList head) {
    // Write your code here.
		if (head == null || head.next == null) {
			return null;
		}
		
		LinkedList slow = head;
		LinkedList fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				LinkedList slow2 = head;
				while (slow != slow2) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow;
			}	
		}
    return null;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
