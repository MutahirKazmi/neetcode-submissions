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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode iterator = null;

        ListNode i1 = list1;
        ListNode i2 = list2;

        while (i1 != null || i2 != null) {
            ListNode node = null;
            if (i1 != null && i2 != null) {
                if (i1.val <= i2.val) {
                    node = new ListNode(i1.val);
                    i1 = i1.next;
                } else {
                    node = new ListNode(i2.val);
                    i2 = i2.next;
                }
            } else if (i1 != null) {
                node = new ListNode(i1.val);
                i1 = i1.next;
            } else if (i2 != null) {
                node = new ListNode(i2.val);
                i2 = i2.next;
            }


            if (head == null) {
                head = node;
                iterator = head;
            } else {
                iterator.next = node;
                iterator = iterator.next;
            }
        }

        return head;
        
    }
}