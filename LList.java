package com.company;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;

public class LList {

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
            return;
        }

        Node last = head;
        while(last.next != null){

            last = last.next;
        }
        last.next = node;


        return;

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

        Node last = head;
        while(last != null){
            System.out.println(last.data);
            last = last.next;
        }
    }
    Node Delete(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        //Delete middle element
        if(head == null || head.next == null){
            return null;
        }


        Node slow = head; Node fast = head;
        Node prev = head;
        while(fast !=null && fast.next !=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    static int loop(Node l1, int place) {

        if(l1 == null){
            return 0;
        }

        int res = (int) (l1.data *(Math.pow(10,place)) + loop(l1.next,(++place)));

        return res;

    }
    static Node pairWiseSwap(Node root) {

        if(root == null || root.next == null){
            return root;
        }

        Node next = root.next;
        root.next = pairWiseSwap(next.next);
        next.next = root;
        return next;


    }
    static void printList(LinkedList head)
    {
        ListIterator listIterator = head.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
    }

    public static void main(String[] args){


        LList ll = new LList();
        ll.append(6);
        ll.append(9);
        //ll.print();
        System.out.println(loop(ll.head,0));
        Node middle = getMiddle(ll.head);
        ll.head = ll.Delete(ll.head);
        ll.print();

        //System.out.println(middle.data);
        System.out.print((ll.toString()));
        LList llist = new LList();

        /* Created Linked List 1->2->3->4->5 */
        llist.append(5);
        llist.append(4);
        llist.append(3);
        llist.append(2);
        llist.append(1);

        System.out.println("Linked List before calling pairWiseSwap() ");
        llist.print();

        Node res = pairWiseSwap(llist.head);
        llist.head = res;
        System.out.println("Linked List after calling pairWiseSwap() ");
        llist.print();

    }
}
