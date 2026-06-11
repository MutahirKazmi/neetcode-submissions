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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (slow != null) {
                slow = slow.next;
            } else {
                return false;
            }

            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }

            if (slow.equals(fast)) {
                return true;
            }
        }
    }
}
