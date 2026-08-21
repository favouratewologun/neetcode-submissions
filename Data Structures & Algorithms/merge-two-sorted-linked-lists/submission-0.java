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
        ListNode head = new ListNode();
        ListNode tracker = head;
        //need a way to make the head not null

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tracker.next = list1;
                tracker = tracker.next;
                list1 = list1.next;
            } else {
                tracker.next = list2;
                tracker = tracker.next;
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            tracker.next = list1;
            tracker = tracker.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            tracker.next = list2;
            tracker = tracker.next;
            list2 = list2.next;
        }

        return head.next;
        
    }
}