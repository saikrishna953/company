package com.company;

// Java Program to print Bottom View of Binary Tree

import org.omg.CORBA.INTERNAL;

import java.util.*;
import java.util.Map.Entry;

// Tree Node1 class
class Node1 {
    int data; //data of the Node1
    int hd; //horizontal distance of the Node1
    Node1 left, right; //left and right references

    // Constructor of tree Node1
    public Node1(int key) {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

//Tree class
class Tree {
    Node1 root; //root Node1 of tree

    // Default constructor
    public Tree() {
    }

    // Parameterized tree constructor
    public Tree(Node1 Node1) {
        root = Node1;
    }

    // Method that prints the bottom view.
    public void bottomView() {
        if (root == null)
            return;

        // Initialize a variable 'hd' with 0 for the root element.
        int hd = 0;

        // TreeMap which stores key value pair sorted on key value
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue to store tree Node1s in level order traversal
        Queue<Node1> queue = new LinkedList<Node1>();

        // Assign initialized horizontal distance value to root
        // Node1 and add it to the queue.
        root.hd = hd;
        queue.add(root);

        // Loop until the queue is empty (standard level order loop)
        while (!queue.isEmpty()) {
            Node1 temp = queue.remove();

            // Extract the horizontal distance value from the
            // dequeued tree Node1.
            hd = temp.hd;

            // Put the dequeued tree Node1 to TreeMap having key
            // as horizontal distance. Every time we find a Node1
            // having same horizontal distance we need to replace
            // the data in the map.
            map.put(hd, temp.data);

            // If the dequeued Node1 has a left child add it to the
            // queue with a horizontal distance hd-1.
            if (temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }
            // If the dequeued Node1 has a left child add it to the
            // queue with a horizontal distance hd+1.
            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }

        // Extract the entries of map into a set to traverse
        // an iterator over that.
        for (Map.Entry<Integer,Integer> entry : map.entrySet()
             ) {
            System.out.print(entry.getValue() + " ");
        }

    }
}

// Main driver class
public class BottomView {
    public static void main(String[] args) {
        Node1 root = new Node1(20);
        root.left = new Node1(8);
        root.right = new Node1(22);
        root.left.left = new Node1(5);
        root.left.right = new Node1(3);
        root.right.left = new Node1(4);
        root.right.right = new Node1(25);
        root.left.right.left = new Node1(10);
        root.left.right.right = new Node1(14);
        Tree tree = new Tree(root);
        System.out.println("Bottom view of the given binary tree:");
        tree.bottomView();
    }
}

