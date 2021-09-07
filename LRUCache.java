package com.company;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {

        int key, value;
        Node next, pre;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = pre = null;
        }

    }

    private static Map<Integer, Node> hsMap;
    private static int capacity, count;
    private static Node head, tail;

    LRUCache(int cap) {
        hsMap = new HashMap<>();
        this.capacity = cap;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
        count = 0;
    }

    // This method works in O(1)
    public static int get(int key) {
        // your code here
        if (hsMap.get(key) != null) {
            Node node = hsMap.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        } else {
            return -1;
        }
    }

    // This method works in O(1)
    public static void set(int key, int value) {
        // your code here
        if (hsMap.get(key) != null) {
            Node node = hsMap.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);

        } else {

            Node node = new Node(key, value);
            hsMap.put(key, node);
            if (count < capacity) {
                addToHead(node);
                count++;
            } else {
                hsMap.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);

            }
        }
    }

    public static void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public static void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
