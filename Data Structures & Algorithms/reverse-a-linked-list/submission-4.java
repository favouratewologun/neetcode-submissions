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

        ListNode currH = head;

        ListNode start = reverseList(currH.next);
        currH.next.next = currH;
        currH.next = null;
        return start;
        //need smth holding curr end of list so we can return it
        
    }
}
