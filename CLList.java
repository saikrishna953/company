package com.company;

public class CLList {

    Node head = null;

    class Node{
        Node next;
        int data;

        Node(int d){
            this.data = d;
            next = null;
        }
    }

    void append(int d){

        Node node = new Node(d);

        if (head == null){
            head = node;
            node.next = head;
            return;
        }

        Node last = head;
        while(last.next != head){

            last = last.next;
        }
        last.next = node;
        node.next =  head;

    }

    void push(int d){

        Node new_node = new Node(d);
        if (head !=null) {
            new_node.next = head;
            head = new_node;
        }else{
            head = new_node;
        }
    }

    void insertAfter(Node prev_node,int d){

        if(prev_node != null) {
            Node new_node = new Node(d);


            new_node.next = prev_node.next;
            prev_node.next = new_node;
        }

    }

    public static Node getMiddle(Node head1)
    {
        if (head1 == null)
            return head1;

        Node slow = head1, fast = head1;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void print(){

        Node temp = head;
        Node last = head;
        while(last.next != temp){
            System.out.println(last.data);
            last = last.next;
        }
    }

    public static void main(String[] args){


        CLList ll = new CLList();
        ll.append(6);
        ll.append(9);
        ll.append(8);
        ll.append(7);
        ll.append(6);
        ll.append(5);
        ll.print();
        /*Node middle = getMiddle(ll.head);
        System.out.println(middle.data);
        System.out.print((ll.toString()));*/

    }
}
