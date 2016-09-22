// Reorder List
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        
        //find the middle 
        ListNode fast = head;
        ListNode slow = head;
        ListNode myPrev = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            myPrev = slow;
            slow = slow.next;
        }
        
        //cut the list from the middle.
        myPrev.next = null;
        
        //reverse the 2nd half
        ListNode curr = slow;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        //merge the two lists
        curr = head;
        ListNode prevNext = null;
        ListNode currNext = null;
        while(curr.next!=null && prev!=null){
            currNext = curr.next;
            prevNext = prev.next;
            curr.next = prev;
            prev.next = currNext;
            prev = prevNext;
            curr = currNext;
        }
        curr.next = prev;        
    }
}
