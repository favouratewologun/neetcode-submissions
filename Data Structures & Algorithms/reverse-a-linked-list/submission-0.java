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

        if (head.next != null) {
            ListNode curr = head;
            ListNode currNext = head.next;

            ListNode newHead = reverseList(currNext);
            currNext.next = curr; //currNext after reversing is now at the end of the line, 
            //make its next element the current
            curr.next = null; //make the next element of the current null, since its now at the end

            return newHead;
        } else {
            return head;
        }        
        
        //1 -> 2 -> 3 -> 4 -> 5-> null
    }
}
