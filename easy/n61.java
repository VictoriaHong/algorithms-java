// Rotate List
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        ListNode fast = head;
        int len = 0;
        while (fast != null) {
            fast = fast.next;
            len++;
        }
        k = k % len;
        if (k == 0) return head;
        fast = head;
        int i = 0;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }
        
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        fast.next = head;
        return head2;
    }
}

// without iterate the whole list to get length
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null || k==0){return head;}
	ListNode fast = head;
	ListNode slow = head;
	for(int i=1;i<=k;i++){
		fast = fast.next;
		if(fast == null){fast=head;k=k%i;i=0;}
	}
	while(fast.next!=null){
		fast = fast.next;
		slow = slow.next;
	}
		
	fast.next = head;
	ListNode newHead=slow.next;
	slow.next = null;
		
        return newHead;
    }
}
