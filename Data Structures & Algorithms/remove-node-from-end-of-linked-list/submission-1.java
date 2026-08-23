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

        if (head.next == null) //only one element
            return null;

        ListNode holdHead = head;
        ListNode holdHead2 = head;

        int countNodes = 1;
        while (holdHead.next != null) {
            countNodes++;
            holdHead = holdHead.next;
        }

        int findIndex = countNodes - n;

        if (findIndex == 0) {
            return head.next;
        }

        for (int ind = 0; ind < findIndex - 1; ind++) { //get node before deleted
            holdHead2 = holdHead2.next;
        }

        holdHead2.next = holdHead2.next.next;

        return head;

        //say have 4 nodes
        //go through pointers until the end, keep track of count
        //subtract count, then update

        //once at the node call it n.
        //need the previous call it p
        //p.next = n.next
        //p.next = p.next.next
        //retrurn head

    }
}
