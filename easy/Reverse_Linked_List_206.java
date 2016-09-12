// Reverse Linked List
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
