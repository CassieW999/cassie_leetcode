import java.util.HashMap;
import java.util.Map;

public class LRUCacheMedium {
    private int capacity;
    private int DLinkedNodeSize;
    private Map<Integer, DLinkedNode> map; // [key, value]
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCacheMedium(int capacity) {
        DLinkedNodeSize = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node != null){
            // exist
            node.value = value;
            moveToHead(node);
        }else{
            // not exist
            DLinkedNode newNode = new DLinkedNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            DLinkedNodeSize++;
            if (DLinkedNodeSize > capacity){
                DLinkedNode tailNode = tail.prev;
                removeNode(tailNode);
                map.remove(tailNode.value);
                DLinkedNodeSize--;
            }
        }
    }

    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {};
        public DLinkedNode(int k, int val){
            this.key = k;
            this.value = val;
        };
    }
}
