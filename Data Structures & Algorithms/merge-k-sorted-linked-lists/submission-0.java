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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        
        return result;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         ListNode resultHead = null;
        ListNode resultIterator = null;
        
        while (true) {
            int val;
            if (l1 != null && l2 != null) {
                val = Math.min(l1.val, l2.val);
                
                if (val == l1.val) {
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                val = l1.val;
                l1 = l1.next;
            } else if (l2 != null) {
                val = l2.val;
                l2 = l2.next;
            } else {
                break;
            }
                        
            if (resultHead == null) {
                resultHead = new ListNode(val);
                resultIterator = resultHead;
            } else {
                ListNode newNode = new ListNode(val);
                resultIterator.next = newNode;
                resultIterator = resultIterator.next;
            }
        }
        
        return resultHead;
    }
}