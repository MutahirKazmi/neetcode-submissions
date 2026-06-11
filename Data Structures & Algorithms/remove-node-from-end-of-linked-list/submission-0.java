/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode iterator1 = dummyNode;
        ListNode iterator2 = dummyNode;
        
        for (int i = 0; i <= n; i++) {
            iterator2 = iterator2.next;
        }
        
        while (iterator2 != null) {    
            iterator2 = iterator2.next;
            iterator1 = iterator1.next;
        }

         iterator1.next = iterator1.next.next;

        return dummyNode.next;
    }
}
