// Remove Linked List Elements
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val != val) {
                cur = cur.next;
            }
            else {
                cur.next = cur.next.next;
            }
        }
        return dummy.next;
    }
}
