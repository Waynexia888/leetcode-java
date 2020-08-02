import java.util.*;

class Program {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // 1. start at the root Node and try simply calling the depthFirstSearch method
            // on all of its children Nodes.
            // 2. then, call the depthFirstSearch method on all children Nodes of each child
            // node
            // keep applying this logic until the entire graph has been traversed.
            // 3. don't forget to add the current Node's name to the input array at every
            // call of depthFirstSearch
            // time: O(v + e), v represents number of vertices or nodes in the graph;
            // e represents the number of edges in the graph
            // space: O(v) because the array we return ia gonna have length v
            array.add(this.name);
            for (int i = 0; i < children.size(); i++) {
                children.get(i).depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
