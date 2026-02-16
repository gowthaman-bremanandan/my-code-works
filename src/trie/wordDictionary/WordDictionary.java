package trie.wordDictionary;

import java.util.*;

public class WordDictionary {

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {

            for (TrieNode child : node.children.values()) {
                if (dfs(word, index + 1, child)) {
                    return true;
                }
            }

            return false;
        } else {

            if (!node.children.containsKey(c)) {
                return false;
            }

            return dfs(word, index + 1,
                    node.children.get(c));
        }
    }
}
