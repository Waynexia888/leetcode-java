/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // 建立集合parentSet，用于存储A的祖先节点。
        // 首先，从A向上遍历到root，将路径中的节点都存储到parentSet中。
        // 然后，从B向上遍历，判断经过的每个节点是否同时也在parentSet中，第一个出现在parentSet中的点即为A和B的最近公共祖先。
        // 时间复杂度：O(k)，k为树的高度。最差情况下，A是叶节点，从A遍历到root需要O(k)的时间。平均情况下时间复杂度也为O(k)。
        // 空间复杂度：O(k)，k为树的高度。最差情况下，A是叶节点，集合中需要存储从A到root的所有节点。平均情况下空间复杂度也为O(k)。
        Set<ParentTreeNode> set = new HashSet<>();
        
        ParentTreeNode current = A;
        while (current != null) {
            set.add(current);
            current = current.parent;
        }
        
        current = B;
        while (current != null) {
            if (set.contains(current)) {
                return current;
            }
            current = current.parent;
        }
        return null;
    }
}