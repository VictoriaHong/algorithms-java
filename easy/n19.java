// Remove Nth Node From End of List
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (n == 0) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // slow is (n + 1)th; fast is the 1st
        while (fast.next != null) {
            fast = fast.next;
            if (n <= 0) slow = slow.next;
            n--;
        }
        if (slow.next != null) slow.next = slow.next.next;
        return dummy.next;
    }
}
