package com.company;

import java.util.HashMap;
import java.util.Map;

public class Try {


    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    static TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Try() {
        this.root = new TrieNode();

    }

    static class TrieNode {
        //TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        Map<Character, TrieNode> children = new HashMap<>();

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            /*for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;*/
        }
    }

    ;

    /**
     * Inserts a word into the
     */
    public void insert(String word) {

        TrieNode pCrawl = root;
        for (char c : word.toCharArray()) {

            if (!pCrawl.children.containsKey(c)) {
                pCrawl.children.put(c,new TrieNode());
            }
            pCrawl = pCrawl.children.get(c);

        }
        pCrawl.isEndOfWord = true;

    }

    /**
     * Returns if the word is in the
     */
    public boolean search(String word) {

        TrieNode pCrawl = root;
        for (char c : word.toCharArray()) {
            if (! pCrawl.children.containsKey(c)) {
                return false;
            }
            pCrawl = pCrawl.children.get(c);
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        TrieNode pCrawl = root;
        for (char c : prefix.toCharArray()) {
            if (! pCrawl.children.containsKey(c)) {
                return false;
            }
            pCrawl = pCrawl.children.get(c);
        }

        return (pCrawl != null);

    }



    public static void main(String[] args) {

        Try obj = new Try();
        obj.insert("app");
        String sai = "skvjndslk";
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("w"));

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
