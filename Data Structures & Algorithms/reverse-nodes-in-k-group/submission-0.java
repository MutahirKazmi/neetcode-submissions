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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode iterator = head;
        int count = 0;
        while (iterator != null) {
            count++;
            iterator = iterator.next;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode subListTail = head;

        List<ListNode[]> subListHeadTail = new ArrayList<>();
        int subListSizeSoFar = 0;
        int subLists = count / k;
        while (curr != null) {
            if (subLists == 0) {
                break;
            }

            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            subListSizeSoFar++;
            
            if (subListSizeSoFar == k) {
                subListHeadTail.add(new ListNode[]{prev, subListTail});
                subLists--;
                subListTail = nxt;
                subListSizeSoFar = 0;
            }
        }

        for (int i = 1; i < subListHeadTail.size(); i++) {
            ListNode [] prevHeadTail = subListHeadTail.get(i-1);
            ListNode [] currHeadTail = subListHeadTail.get(i);

            prevHeadTail[1].next = currHeadTail[0];
        }

        ListNode lastListTail = subListHeadTail.get(subListHeadTail.size() - 1)[1];
        lastListTail.next = curr;       

        return subListHeadTail.get(0)[0];
    }
}
