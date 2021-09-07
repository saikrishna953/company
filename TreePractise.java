package com.company;

import java.util.TreeMap;

public class TreePractise {

    static int maxPathSum_val = 0;

    public static void main(String[] args) {

                   /* 2
               7              12
            2       6       4     9
                 5     11*/


        Node node = new Node(2);
        node.left = new Node(7);
        node.right = new Node(12);
        node.left.left = new Node(2);
        node.right.right = new Node(9);
        node.right.left = new Node(4);
        node.left.right = new Node(6);
        node.left.right.left = new Node(5);
        node.left.right.right = new Node(11);
        System.out.println("Full Binary tree check -" + isFullBinaryTree(node));
        System.out.println("Symmetric tree check -" + isSymmetric(node, node));
        boolean result = checkBalanced(node);
        System.out.println("Is tree balanced? " + result);
        int a = lca(node, 5, 11);
        System.out.println("lca of 5 & 11 is " + a);
        System.out.println("Left View of node is");
        leftView(node);
        System.out.println("\nMax sum path " + maxSumPath(node));
        ;
        rightView(node);
        System.out.println("\nMirror tree printing before -");
        preOrderTraversal(node);
        System.out.println("\nRoot to leaf path sum 10 -" + rootToLeafPathSum(node,10));
        System.out.println("\nMirror tree printing after -");
        mirrorTree(node);
        preOrderTraversal(node);



    }

    private static int maxSumPath(Node node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) return node.key;
        int l = maxSumPath(node.left);
        int r = maxSumPath(node.right);
        if (node.left != null && node.right != null) {
            maxPathSum_val = Math.max(l + r + node.key, maxPathSum_val);
            return Math.max(l, r) + node.key;

        }
        if (node.left == null)
            return r + node.key;
        else
            return l + node.key;


    }

    static int max_level = 0;

    private static void leftView(Node node) {
        int level = 1;
        leftViewUtil(node, level);
        return;

    }

    private static void leftViewUtil(Node node, int level) {

        if (node == null) return;
        if (max_level < level) {
            System.out.print(node.key + " ");
            max_level = level;
        }
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    private static int lca(Node node, int i, int i1) {

        if (node == null) return -1;

        if (node.key == i || node.key == i1) {
            return node.key;
        }

        int l = lca(node.left, i, i1);
        int r = lca(node.right, i, i1);

        if (l != -1 && r != -1) {
            return node.key;
        }

        return l != -1 ? l : r;

    }

    private static boolean checkBalanced(Node node) {
        Height height = new Height();
        return checkBalancedUtil(node, height);
    }

    private static boolean checkBalancedUtil(Node node, Height height) {

        if (node == null) {
            height.height = 0;
            return true;
        }
        Height l = new Height();
        Height r = new Height();
        boolean lh = checkBalancedUtil(node.left, l);
        boolean rh = checkBalancedUtil(node.right, r);
        height.height = 1 + Math.max(l.height, r.height);
        if (Math.abs(l.height - r.height) > 1) {
            return false;
        } else {
            return lh && rh;
        }


    }

    private static boolean isFullBinaryTree(Node root) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.right != null) {
            return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
        }
        return false;
    }

    private static boolean isSymmetric(Node root1, Node root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if ((root1 != null && root2 != null) && (root1.key == root2.key)) {
            return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        }

        return false;
    }

    private static int preIndex;

    private static Node buildTreeFromInorderPreOrder(int[] in, int pre[], int st, int end) {

        if (st > end) {
            return null;
        }

        Node tNode = new Node(pre[preIndex++]);

        if (st == end) {
            return tNode;
        }

        int ind = searchInInorder(in, st, end, tNode.key);

        tNode.left = buildTreeFromInorderPreOrder(in, pre, st, ind - 1);
        tNode.right = buildTreeFromInorderPreOrder(in, pre, ind + 1, end);

        return tNode;

    }

    private static int searchInInorder(int[] in, int st, int end, int key) {

        for (int i = st; i <= end; i++) {
            if (in[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.key + " ");
        inOrderTraversal(root.right);
    }

    private static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        inOrderTraversal(root.left);

        inOrderTraversal(root.right);
    }

    private static void getHdSums(Node root, TreeMap<Integer, Integer> map) {

        if (root == null) {
            return;
        }

        getHdSums(root.left, map);
        int prevSum = map.getOrDefault(root.hd, 0);
        map.put(root.hd, prevSum + root.hd);
        getHdSums(root.right, map);


    }

    private static void rightView(Node node) {
        int level = 1;
        max_level = 0;
        System.out.println("Right view");
        rightViewUtil(node, level);
        return;

    }

    private static void rightViewUtil(Node root, int level) {

        if (root == null) {
            return;
        }

        if (level > max_level) {
            System.out.print(root.key + " ");
            max_level = level;
        }

        rightViewUtil(root.right, level + 1);
        rightViewUtil(root.left, level + 1);


    }

    private static void mirrorTree(Node root) {

        if (root == null) {
            return;
        }

        mirrorTree(root.left);
        mirrorTree(root.right);

        Node temp = root.right;
        root.right = root.left;
        root.left = temp;


    }

    private static int height(Node root) {

        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }

    }

    static int diaM = 0;

    private static int diameter(Node root) {

        if (root == null) {
            return 0;
        }

        int l = diameter(root.left);
        int r = diameter(root.right);

        if (diaM < (l + r + 1)) {
            diaM = l + r + 1;
        }

        return 1 + Math.max(l, r);

    }

    private static boolean rootToLeafPathSum(Node root, int sum) {

        if (root == null) {
            return sum == 0;
        }

        int remSum = Math.abs(sum - root.key);
        boolean ans = false;
        if (remSum == 0 && root.left == null && root.right == null) {
            return true;
        }
        if(root.left != null){
            ans = ans || rootToLeafPathSum(root.left,remSum);
        }
        if(root.right != null){
            ans = ans || rootToLeafPathSum(root.right,remSum);
        }

        return ans;


    }
}
