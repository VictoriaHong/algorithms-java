// LRU Cache
// hashmap + doublelinedlist
public class LRUCache {
    int cap;
    int size;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        head.pre = null;
        tail.next = head;
        tail.pre = null;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            delete(tmp);
            addToHead(tmp);
            return tmp.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            tmp.val = value;
            delete(tmp);
            addToHead(tmp);
            map.put(key, tmp);
        }
        else {
            Node tmp = new Node(key, value);
            map.put(key, tmp);
            if (this.size >= this.cap) {
                Node del = tail.pre;
                map.remove(del.key);
                delete(del);
                addToHead(tmp);
            }
            else {
                addToHead(tmp);
                this.size++;
            }
        }
    }
    
    public void delete(Node n) {
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }
    
    public void addToHead(Node n) {
        n.pre = head;
        n.next = head.next;
        head.next.pre = n;
        head.next = n;
    }
}

class Node {
    int key;
    int val;
    Node pre;
    Node next;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// LinkedHashMap
public Solution {
    private int capacity;
    private int actNum = 0;
    
    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    }
    
    public int get(int key) {
    	Integer value = map.get(key);
    	if (value == null) {
    		return -1;
    	} else {
    		map.remove(key);
    		map.put(key, value);
    	}
    	return value;
    }
    
    public void set(int key, int value) {
    	Integer v = map.get(key);
    	if (v != null) {
    		map.remove(key);
    		map.put(key, value);
    	} else {
    		if (actNum == capacity) {
    			map.remove(map.keySet().iterator().next());
    			actNum--;
    		}
    		map.put(key, value);
    		actNum++;
    	}
    }
}
