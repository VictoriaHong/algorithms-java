// Intersection of Two Linked Lists
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) { // break when they are the same node or both null
            if (curA != null) curA = curA.next;
            else curA = headB;
            
            if (curB != null) curB = curB.next;
            else curB = headA;
        }
        return curA;
    }
}
