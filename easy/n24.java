// Swap Nodes in Pairs
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = null;
        
        while (cur != null && cur.next != null) {
            next = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            cur = next;
            pre = pre.next.next;
        }
        return dummy.next;
    }
}
