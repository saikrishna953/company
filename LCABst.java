package com.company;

// Java Program for Lowest Common Ancestor in a Binary Tree
// A O(n) solution to find LCA of two given values n1 and n2
import java.util.ArrayList;
        import java.util.List;

// A Binary Tree Node2
class Node2 {
    int data;
    Node2 left, right;

    Node2(int value) {
        data = value;
        left = right = null;
    }
}

public class LCABst
{

    Node2 root;
    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();

    // Finds the path from root Node2 to given root of the tree.
    int findLCA(int n1, int n2) {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }

    private int findLCAInternal(Node2 root, int n1, int n2) {

        if(!findPath(root,n1,path1) || !findPath(root,n2,path2)){
            System.out.println("n1 or n2 is missing in the tree");
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size() ; i++) {

            if(!path1.get(i).equals(path2.get(i))){
                break;
            }
        }

        return path1.get(i-1);
    }

    private boolean findPath(Node2 root, int n1, List<Integer> path) {

        if (root == null){
            return false;
        }

        path.add(root.data);
        if(root.data == n1){
            return true;
        }

        if(root.left != null && findPath(root.left,n1,path)){
            return true;
        }
        if(root.right !=null && findPath(root.right,n1,path)){
            return true;
        }

        path.remove(path.size()-1);
        return false;

    }


    // Driver code
    public static void main(String[] args)
    {
        LCABst tree = new LCABst();
        tree.root = new Node2(1);
        tree.root.left = new Node2(2);
        tree.root.right = new Node2(3);
        tree.root.left.left = new Node2(4);
        tree.root.left.right = new Node2(5);
        tree.root.right.left = new Node2(6);
        tree.root.right.right = new Node2(7);

        System.out.println("LCA(4, 10): " + tree.findLCA(4,5));
        System.out.println("LCA(4, 6): " + tree.findLCA(4,6));
        System.out.println("LCA(3, 4): " + tree.findLCA(3,4));
        System.out.println("LCA(2, 4): " + tree.findLCA(2,4));

    }
}
// This code is contributed by Sreenivasulu Rayanki.

