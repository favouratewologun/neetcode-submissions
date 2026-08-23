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
    public void reorderList(ListNode head) {
        int size = 1;

        ListNode headCount = head;

        while (headCount.next != null) {
            size++;
            headCount = headCount.next;
        }

        int orderSize = size / 2;

        ListNode finalHead = head;
        headCount = finalHead;

        //just keep going to next, then set to null

        while (orderSize > 0) {
            headCount = headCount.next;
            orderSize--;
        }

        ListNode stackPush = headCount.next;
        headCount.next = null;
        Deque<ListNode> stack = new ArrayDeque<ListNode>();

        while (stackPush != null) {
            stack.push(stackPush);
            stackPush = stackPush.next;
        }

        ListNode everyOther = finalHead;
        while (stack.peek() != null) {
        // while (everyOther.next != null) {
            ListNode currNext = everyOther.next;
            ListNode toAdd = stack.pop();
            everyOther.next = toAdd;
            toAdd.next = currNext;
            everyOther = currNext;
        }

        //0 1 2 3
        // 4 5 6

        //0 1 2 3 4 5 6
        //0 6 1 5 2 4 3
        //0 
        // 1
        //stack: 1

        //0 1 2 3 (increasing)
        //n - 1, n- 2, n-3 (decreasing)

        //can add the first half normally, push the second half onto a stack,
        //then every other node, update next

        //0, 1, 2, 3
        //bottom: 4 5 6

        //0 6 1 5 2 4 3

        //2 4 6 8
        //2 8 4 6
        
    }
}
