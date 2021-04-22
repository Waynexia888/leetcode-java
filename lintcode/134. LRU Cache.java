public class LRUCache {
    /*
    * @param capacity: An integer
    */
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
        // do intialization if necessary
        this.capacity = capacity;     // 容积
        this.keyToPrev = new HashMap<Integer, ListNode>();    // 哈希表
        this.dummy = new ListNode(0, 0);   // 哨兵节点
        this.tail = this.dummy;  // 末尾节点，作用是方便在末尾插入新节点
    }
    
    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);   //该key对应的节点的前面一个节点
        ListNode currentNode = prev.next;  // 该key对应的节点
        
        if (tail == currentNode) {      // 如果该key对应的节点就是末尾，就不用移动了
            return;
        }
        
        prev.next = prev.next.next;   // 删除currentNode这个节点
        tail.next = currentNode;   // 在末尾加入currentNode节点
        currentNode.next = null;   // currentNode节点的next指向null
        
        // if (prev.next != null) {
        //     keyToPrev.put(prev.next.key, prev);
        // }
        // 此时头节点移到末尾了，所以需要更新头节点信息，以及末尾节点信息
        keyToPrev.put(prev.next.key, prev); 
        keyToPrev.put(currentNode.key, tail);
        
        tail = currentNode;    //更新tail节点位置
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // 如果哈希表中没有该key，返回-1
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        // 如果有该key，就把该key对应的节点移到链表末尾，表示最近已经访问了
        moveToTail(key);
        // 此时链表末尾就是该key的节点，返回该节点对应的val即可
        return tail.val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // 若果key存在，此时key已经被移到链表的末尾
        if (get(key) != -1) {
            tail.val = value;
            return;
        }
        
        // 如果key不存在，检查capacity是否已满
        // 如果capacity没满，那么直接加就好了
        if (size < capacity) {
            size++;
            ListNode current = new ListNode(key, value);  // 把key和value包装成节点
            tail.next = current;  // 将该节点放入链表末尾
            keyToPrev.put(key, tail);  // 哈希表保存一下
            tail = tail.next;   // 更新一下tail的位置
            return;
        }
        
        // 如果capacity满了，那么需要删除头节点，然后再末尾加入新的
        ListNode first = dummy.next;  //获取头节点
        keyToPrev.remove(first.key);  // 哈希表中删除头节点
        
        first.key = key;     // 更换头节点的key和value
        first.val = value;
        keyToPrev.put(key, dummy);  // 哈希表中保存该key，以及key的前节点
        
        // 此时key对应的是first节点， 把first节点移到链表末尾
        moveToTail(key);  
        
    }
}