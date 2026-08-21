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
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        
        if (head.next == null)
            return head;

        ListNode curr = head;
        ListNode currNext = head.next;

        ListNode reversedHead = reverseList(currNext);
        currNext.next = curr;
        curr.next = null;

        return reversedHead;
        
    }
}
