// Palindrome Linked List s: O(1) t: O(n)
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // now slow is the center of the list
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode l1 = head;
        
        // reverse latter part;
        l2 = reverse(l2);
        
        // compare 2 parts
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return true;
    }
    
    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}

// without modify the list
// https://discuss.leetcode.com/topic/19987/if-you-want-o-n-time-and-o-1-space-this-problem-should-not-be-an-easy-one/2
