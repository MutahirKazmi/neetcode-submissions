/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> originalNodeToClone = new HashMap<>();
        Node iterator = head;
        Node copyHead = null;
        Node copyIterator = null;

        while (iterator != null) {
            Node clone = new Node(iterator.val);
            if (copyHead == null) {
                copyHead = clone;
                copyIterator = copyHead;
            } else {
                copyIterator.next = clone;
                copyIterator = copyIterator.next;
            }

            originalNodeToClone.put(iterator, clone);
            iterator = iterator.next;
        }

        iterator = head;

        while (iterator != null) {
            Node clone = originalNodeToClone.get(iterator);
            Node randomClone = originalNodeToClone.get(iterator.random);
            clone.random = randomClone;

            iterator = iterator.next;
        }

        return copyHead;
    }
}
