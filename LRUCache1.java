package com.company;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache1 {

    private static HashMap<Integer, LNode> map;
    private static LNode head, tail;
    private static int count;
    private static int capacity;

    LRUCache1(int cap) {
        map = new HashMap<>();
        head = new LNode(0, 0);
        tail = new LNode(0, 0);
        head.next = tail;
        tail.prev = head;
        this.count = 0;
        this.capacity = cap;
    }

    public void setCache(int key,int value){

        if(map.containsKey(key)){
            LNode val = map.get(key);
            val.value = value;
            deleteNode(val);
            addToHead(val);
        }else{
            LNode node = new LNode(key,value);
            count++;
            map.put(key,node);
            if(count > capacity){
                map.remove(tail.prev.key);
                deleteNode(tail.prev);

                count--;
            }
            addToHead(node);
        }

    }

    public  int getCache(int key){

        if(map.get(key) != null){
            LNode node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }else{
            return -1;
        }

    }

    private static void deleteNode(LNode val) {
        val.prev.next = val.next;
        val.next.prev = val.prev;

    }

    private static void addToHead(LNode val) {
        val.next = head.next;
        head.next.prev = val;
        head.next = val;
        val.prev = head;
    }

    public static void main(String... args){
        LRUCache1 lruCache1 = new LRUCache1(2);
        lruCache1.setCache(4,6);
        lruCache1.setCache(3,7);
        lruCache1.setCache(7,87);
        System.out.print(lruCache1.getCache(4));
    }

}
