package com.company;

public class DLList {

    Node head;


    class Node<E>{

        Node next;
        Node prev;
        E d;

        Node(E d){
            this.d = d;
            this.next = null;
            this.prev = null;
        }

    }

    void push(int d){

        Node new_node = new Node(d);
        if (head == null){
             head = new_node;
             return;
        }

        new_node.next = head;
        head.prev =  new_node;

        head = new_node;


    }

    void reverse(){

        Node current = head;
        Node temp = null;

        while(current != null){

            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp !=null){
            head = temp.prev;
        }

    }

    void append(int d){

        Node new_node = new Node(d);
        if (head == null){
            head = new_node;
            return;
        }

        Node last = head;
        while(last.next !=null){
            last = last.next;
        }

        last.next =  new_node;
        new_node.prev = last;
        return;

    }
    void insertAfter(Node prev_node, int d){

        Node new_node = new Node(d);
        if (prev_node == null){

            return;
        }

        new_node.next = prev_node.next;
        prev_node.next = new_node;
        new_node.prev = prev_node;
        if (new_node.next != null)
            new_node.next.prev = new_node;
        return;

    }


    public static void main(String[] args){

        DLList dll = new DLList();
        dll.push(78);
        dll.push(90);
        dll.append(23);
        dll.push(9);

        dll.insertAfter(dll.head.next.next,34);

        printarr(dll);
        dll.reverse();
        printarr(dll);

    }

    private static void printarr(DLList dll) {

        Node node = dll.head;

        while(node !=null){

            System.out.println(node.d);
            node = node.next;

        }
    }
}
