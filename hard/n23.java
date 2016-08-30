// Merge k Sorted Lists
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int n = lists.length;
        ListNode res = mergeHelper(lists, 0, n - 1);
        return res;
    }
    
    public ListNode mergeHelper(ListNode[] lists, int i, int j) {
        if (i == j) return lists[i];
        
        int mid = i + (j - i)/2;
        ListNode left = mergeHelper(lists, i, mid);
        ListNode right = mergeHelper(lists, mid + 1, j);
        return merge(left, right);
    }
    
    public ListNode merge(ListNode i, ListNode j) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (i !=null && j != null) {
            if (i.val < j.val) {
                cur.next = i;
                i = i.next;
            }
            else {
                cur.next = j;
                j = j.next;
            }
            cur = cur.next;
        }
        while (i != null) {
            cur.next = i;
            cur = cur.next;
            i = i.next;
        }
        while (j != null) {
            cur.next = j;
            cur = cur.next;
            j = j.next;
        }
        return dummy.next;
    }
}
