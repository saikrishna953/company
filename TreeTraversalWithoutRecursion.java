package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class TreeTraversalWithoutRecursion {
    ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<Integer> postOrderIterative(Node node) {

        Stack<Node> S = new Stack<Node>();

        // Check for empty tree
        if (node == null)
            return list;
        S.push(node);
        Node prev = null;
        while (!S.isEmpty()) {
            Node current = S.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current ||
                    prev.right == current) {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.key);
                }

                /* go up the tree from left node, if the child is right
                   push it onto stack otherwise process parent and pop
                   stack */
            } else if (current.left == prev) {
                if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.key);
                }

                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            } else if (current.right == prev) {
                S.pop();
                list.add(current.key);
            }

            prev = current;
        }

        return list;

    }

    private void postOrderIterative1(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            // Check for empty stack
            if (stack.empty()) return;
            root = stack.pop();

            if (!stack.empty() && stack.peek() == root) root = root.right;

            else {

                System.out.print(root.key + " ");
                root = null;
            }
        }
    }

    void inorderIterative(Node root) {
        if (root == null)
            return;


        Stack<Node> s = new Stack<Node>();
        Node curr = root;

        // traverse the tree 
        while (curr != null || s.size() > 0) { 
  
            /* Reach the left most Node of the 
            curr Node */
            while (curr != null) { 
                /* place pointer to a tree node on 
                   the stack before traversing 
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.print(curr.key + " "); 
  
            /* we have visited the node and its 
               left subtree.  Now, it's right 
               subtree's turn */
            curr = curr.right;
        }
    }

    void iterativePreorder(Node node) {

        // Base Case
        if (node == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(node);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (nodeStack.empty() == false) {

            // Pop the top item from stack and print it
            Node mynode = nodeStack.peek();
            System.out.print(mynode.key + " ");
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
    }

    void printLevelOrder(Node root)
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
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

    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }



    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

        // Let us create trees shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        TreeTraversalWithoutRecursion pot = new TreeTraversalWithoutRecursion();

        ArrayList<Integer> mylist = pot.postOrderIterative(tree.root);

        System.out.println("Post order traversal of binary tree is :");
        System.out.println(mylist);
    }
}
