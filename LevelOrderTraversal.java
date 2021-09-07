package com.company;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        traverse(root);



    }

    private static void traverse(Node root) {

        Queue<Node> queue =   new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0 ){

            Node d= queue.poll();
            System.out.print(d.data + " ");

            if(d.left != null){
                queue.add(d.left);
            }
            if(d.right != null){
                queue.add(d.right);
            }

        }

    }

    static class Node{

        int data;
        Node left;
        Node right;

        Node(int d){
            this.data = d;
        }

    }
}
