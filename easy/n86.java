// Partition List
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode cur = head;
        ListNode lesshead = less;
        ListNode morehead = more;
        
        while (cur != null) {
            if (cur.val < x) {
                less.next = cur;
                less = less.next;
            }
            else {
                more.next = cur;
                more = more.next;
            }
            cur = cur.next;
        }
        more.next = null; // otherwise there will be a cycle
        less.next = morehead.next;
        return lesshead.next;
    }
}
