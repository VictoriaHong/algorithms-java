// Remove Duplicates from Sorted List
// iterative
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        
        ListNode pre = head;
        ListNode next = null;
        ListNode cur = head.next;
        while (cur != null) {
            next = cur.next;
            if (cur.val == pre.val) {
                ListNode tmp = cur;
                pre.next = next;
                tmp = null;
            }
            else {
                pre = pre.next;
            }
            cur = next;
        }
        return head;
    }
}

// recursive
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
