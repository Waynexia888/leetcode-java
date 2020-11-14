class LRUCache {
    class ListNode {
        public int key, val;
        public ListNode next;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;   
        }
    }

    private int capacity, size;
    private ListNode dummy, tail;
    private Map<Integer, ListNode> keyToPrev;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = size;
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;
        this.keyToPrev = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        // if key not exist
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        
        // key exist
        moveToTail(key);
        return tail.val;
    }
    
    public void put(int key, int value) {
        // key exist, update the value
        if (get(key) != -1) {
            tail.val = value;
            return;
        }
        
        // key not exist, and the capacity is not full
        if (size < capacity) {
            size++;
            ListNode node = new ListNode(key, value);
            tail.next = node;
            keyToPrev.put(key, tail);
            tail = tail.next;
            return;
        }
        
        // key not exist, and the capacity is full
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        
        first.key = key;
        first.val = value;
        keyToPrev.put(first.key, dummy);
        moveToTail(first.key);
    }
    
    public void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode temp = prev.next;
        
        if (temp == tail) {
            return;
        }
        
        prev.next = temp.next;
        tail.next = temp;
        temp.next = null;
        
        keyToPrev.put(prev.next.key, prev);
        keyToPrev.put(temp.key, tail);
        
        tail = tail.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// hashmap + Linked List
// hashmap: key: key, which is an Integer; value: previous node, which is a ListNode
// time: O(1); space: O(capacity)