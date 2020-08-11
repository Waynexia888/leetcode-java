/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // 所有 深度拷贝 的问题都可以通过使用 哈希表 来实现（使用了O(N)的额外空间）
        // 具体做法为：
        // 使用HashMap的 key 来存储原来的节点，value 来储存复制后new出来的节点。
        // 这样我们便有了 复制之后的节点 与 原版节点 的映射关系。
        // 然后我们再次从头到尾遍历一次链表，并借助于 复制节点和原来节点的 映射关系，
        // 将复制后的节点的 next 和 random 指针 与 对应的节点 连接起来。
        // eg. 假设对于节点 curr, 通过映射关系我们知道其复制节点为 map.get(curr)，
        // 并且我们可以通过原来节点的 next指针 和 random指针 找到其所对应的节点。
        // 而这些节点又能够根据建立好的 映射关系 得到其复制节点。
        // 因此 curr节点的拷贝节点 map.get(curr) 的 next 指针指向 map.get(curr.next),
        //   map.get(curr).next = map.get(curr.next);
        // 同理我们也可以得到 curr 拷贝节点的 random 指针应该指向：
        //  map.get(curr).random = map.get(curr.random);
        // 时间复杂度为：O(n);  空间复杂度为：O(n)
        
        if (head == null) {
            return null;
        }
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        // copy all the nodes 
        RandomListNode current = head;
        while (current != null) {
            map.put(current, new RandomListNode(current.label));
            current = current.next;
        }
        
        // copy the mapping (assign next and random pointers)
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
}