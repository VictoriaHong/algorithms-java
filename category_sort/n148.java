// merge sort
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head.next.next;
        
        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode l2 = sortList(slow.next);
        slow.next = null;
        ListNode l1 = sortList(head);
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1 == null)?l2:l1;
        return dummy.next;
    }
}

// 3-way quick sort
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    
    ListNode dummy1 = new ListNode(0);
    ListNode dummy2 = new ListNode(0);
    ListNode prev1 = dummy1;
    ListNode prev2 = dummy2;
    ListNode node = head.next;
    ListNode prev = head;
    while (node != null) {
        if (node.val < head.val) {
            prev1.next = node;
            prev1 = prev1.next;
        } else if (node.val > head.val) {
            prev2.next = node;
            prev2 = prev2.next;
        } else {
            prev.next = node;
            prev = prev.next;
        }
        node = node.next;
    }
    
    prev1.next = prev2.next = prev.next = null;
    dummy1.next = sortList(dummy1.next);
    dummy2.next = sortList(dummy2.next);
    prev1 = dummy1;
    while (prev1.next != null) {
        prev1 = prev1.next;
    }
    
    prev1.next = head;
    prev.next = dummy2.next;
    return dummy1.next;
}
