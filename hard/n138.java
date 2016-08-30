// Copy List with Random Pointer
// hashmap t: O(2n) s: O(n)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode cur = head.next;
        RandomListNode copy = newHead;
        map.put(head, newHead);
        
        while (cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            map.put(cur, tmp);
            cur = cur.next;
            copy.next = tmp;
            copy = copy.next;
        }
        
        cur = head;
        while (cur != null) {
            RandomListNode cp = map.get(cur);
            cp.random = map.get(cur.random);
            cur = cur.next;
        }
        return newHead;
    }
}

// trick
// append copied node to original node t: O(3n) s: O(1)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        
        RandomListNode cur = head;
        
        while (cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }
        
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null? null : cur.random.next;
            cur = cur.next.next;
        }
        
        cur = head;
        RandomListNode copyHead = new RandomListNode(0);
        RandomListNode copy = copyHead;
        while (cur != null && cur.next != null) {
            copy.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            copy = copy.next;
        }
        return copyHead.next;
    }
}
