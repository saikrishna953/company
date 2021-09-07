package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class TreeMain {

    public static void main(String[] args) {
        System.out.println("skjfhdnjc");

        /* Constructing below tree
               5
             /   \
            3     6
           / \     \
          1   4     8  */
        BinaryTree tree = new BinaryTree();
        TreeMain tm = new TreeMain();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);
        tree.root.right.right = new Node(8);

        System.out.println(tree);
        System.out.println(tm.height(tree.root));


        LinkedList<Integer> sai = new LinkedList<Integer>();
        sai.add(23);
        sai.spliterator().tryAdvance(System.out::println);

        System.out.print("Inorder traversal before insertion:");
        inorder(tree.root);

        int key = 12;
        insert(tree.root, key);

        System.out.print("\nInorder traversal after insertion:");
        inorder(tree.root);

        System.out.print("\npreorder traversal after insertion:");
        preorder(tree.root);

        System.out.print("\npostorder traversal after insertion:");
        postorder(tree.root);

        List<Integer> iu = new ArrayList<>();
        iu.add(12);
        iu.add(45);
        iu.add(0);
        iu.add(45);
        Iterator<Integer> it9 = iu.iterator();
        while (it9.hasNext()) {
            System.out.println(it9.next());
        }
        iu.sort(Integer::compareTo);

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add("Sai");
        pq.add("krishna");
        pq.add("naidu");
        pq.add("firoz");
        pq.add("naidu");

        System.out.println("first time");
        System.out.println(pq);
        pq.poll();

        System.out.println("second time");
        System.out.println(pq);
        System.out.println("third time");
        //pq.remove("naidu");
        pq.add("aa");
        pq.add("qwe");
        System.out.println(pq);

        System.out.println("fourth time");

        System.out.println(pq.stream().sorted(String::compareTo).collect(Collectors.toList()).toString());


    }

    /* Inorder traversal of a binary tree*/
    static void inorder(Node temp) {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }

    static void preorder(Node temp) {
        if (temp == null)
            return;
        System.out.print(temp.key + " ");
        preorder(temp.left);
        preorder(temp.right);
    }

    static void postorder(Node temp) {
        if (temp == null)
            return;

        postorder(temp.left);
        postorder(temp.right);
        System.out.print(temp.key + " ");
    }

    /*function to insert element in binary tree */
    static void insert(Node temp, int key) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);


        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else
                q.add(temp.right);
        }


    }
    int height(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }
}
