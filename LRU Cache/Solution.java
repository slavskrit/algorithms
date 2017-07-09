import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by dpronin on 4/4/17.
 */
public class LRUCache {

    class Node {
        int key;
        int value;
        Node left;
        Node right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    final int capacity;
    Node head;
    Node tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.right = tail;
        this.tail.left = head;
    }

    private void add(Node node) {
        head.right.left = node;
        node.right = head.right;
        node.left = head;
        head.right = node;
    }

    private void remove(Node node) {
        node.left.right = node.right;
        node.right.left = node.left;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n != null) {
            remove(n);
            add(n);
            return n.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node t = map.get(key);
        if (t == null) {
            if (map.size() == this.capacity) {
                map.remove(tail.left.key);
                tail = tail.left;
            }
            Node n = new Node(key, value);
            add(n);
            map.put(key, n);
        } else {
            remove(t);
            add(t);
            t.value = value;
        }
    }
}
