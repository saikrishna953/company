package com.company;

public class LNode {

    int key,value;
    LNode next,prev;

    LNode(int key,int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
