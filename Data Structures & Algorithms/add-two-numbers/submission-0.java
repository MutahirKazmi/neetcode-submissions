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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i1 = l1;
        ListNode i2 = l2;

        int carry = 0;

        ListNode head = null;
        ListNode i3 = null;

        while (i1 != null || i2 != null) {
            ListNode res;
            int sum = 0;
            if (i1 != null && i2 != null) {
                sum = i1.val + i2.val + carry;
                i1 = i1.next;
                i2 = i2.next;
            } else if (i1 != null) {
                sum = i1.val + carry;
                i1 = i1.next;
            } else if (i2 != null) {
                sum = i2.val + carry;
                i2 = i2.next;
            }

            carry = sum / 10;
            sum = sum >= 10 ? sum - 10 : sum;
            res = new ListNode(sum);

            if (head == null) {
                head = res; 
                i3 = head;
            } else {
                i3.next = res;
                i3 = i3.next;
            }
        }

        if (carry > 0) {
            i3.next = new ListNode(carry);
        }

        return head;
    }
}
