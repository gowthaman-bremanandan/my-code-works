package trie.prefixTree;

import java.util.*;

public class PrefixTree {

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {

            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {

        TrieNode node = traverse(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {

        return traverse(prefix) != null;
    }

    private TrieNode traverse(String str) {

        TrieNode current = root;

        for (char c : str.toCharArray()) {

            if (!current.children.containsKey(c)) {
                return null;
            }

            current = current.children.get(c);
        }

        return current;
    }
}
