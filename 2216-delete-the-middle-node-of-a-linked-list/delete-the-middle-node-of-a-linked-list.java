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
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head, slow = head, prev = null;
        
        // fast pointer, slow pointer
        while (true) {
            // If fast.next is true but next.next is null then one more iteration of slow
            if (fast.next != null && fast.next.next == null) {
                prev = slow;
                slow = slow.next;
                break;
            } else if (fast.next == null) {
                break;
            } else {
                fast = fast.next.next;
            }
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            return null;
        }
        // middle is the slow pointer
        prev.next = slow.next;

        return head;
    }
}