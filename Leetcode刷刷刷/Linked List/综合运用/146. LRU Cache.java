class LRUCache {
    
    // use linked list data structure
    class ListNode {
        public int key, val;
        public ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    
    public int capacity, size;
    public ListNode dummy;
    public ListNode tail;
    // use hashmap data structure; key: the key of current node; value: previous node of current node
    public Map<Integer, ListNode> keyToPrev;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = size;
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;
        this.keyToPrev = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        // key is not exist
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        
        // key is exist
        moveToTail(key);
        return tail.val;
    }
    
    public void put(int key, int value) {
        // key exist, update its value
        if (get(key) != -1) {
            tail.val = value;
            return;
        }
        
        // key not exist, and the capacity is not full
        //        add a new node to the end of the list
        if (size < capacity) {
            size++;
            ListNode newNode = new ListNode(key, value);
            tail.next = newNode;
            keyToPrev.put(key, tail);
            tail = tail.next;
            return;  
        }
        
        // key not exist, and the capacity is full
        //        remove the old first node, and add a new node in the end
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        
        first.key = key;
        first.val = value;
        keyToPrev.put(first.key, dummy);
        moveToTail(first.key);
    }
    
    private void moveToTail(int key) {
        // previous node 
        ListNode prev = keyToPrev.get(key);
        ListNode currentNode = prev.next;
        
        // check if currentNode is in the end of the list
        if (currentNode == tail) {
            return;
        }
        
        // otherwise, re-construct the linked list
        prev.next = currentNode.next;
        tail.next = currentNode;
        currentNode.next = null;
        
        // update the hashmap
        keyToPrev.put(prev.next.key, prev);
        keyToPrev.put(currentNode.key, tail);
        
        // update the tail
        tail = tail.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// why LinkedList?
//     use O(1) time complexity to insert and delete one element if we know the previous node
    
// why HashMap?
//     insertion, deletion, and search takes O(1) constant time. 
// time: O(1); space: O(capacity)