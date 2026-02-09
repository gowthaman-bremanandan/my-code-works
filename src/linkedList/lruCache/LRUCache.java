package linkedList.lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // Doubly Linked List Node
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }

        if (map.size() == capacity) {
            // Remove LRU node
            Node lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        addToFront(newNode);
        map.put(key, newNode);
    }

    // ---- Doubly Linked List Helpers ----

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // ---- Main Method ----
    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 10);   // cache: {1=10}
        System.out.println(lruCache.get(1)); // 10

        lruCache.put(2, 20);   // cache: {1=10, 2=20}
        lruCache.put(3, 30);   // evicts key 1

        System.out.println(lruCache.get(2)); // 20
        System.out.println(lruCache.get(1)); // -1
    }
}
