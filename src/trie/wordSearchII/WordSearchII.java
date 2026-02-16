package trie.wordSearchII;

import java.util.*;

public class WordSearchII {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null; // store full word at end
    }

    public static void main(String[] args) {

        char[][] board = {
                {'a','b','c','d'},
                {'s','a','a','t'},
                {'a','c','k','e'},
                {'a','c','d','n'}
        };

        String[] words = {"bat","cat","back","backend","stack"};

        System.out.println(findWords(board, words));

        char[][] board2 = {
                {'x','o'},
                {'x','o'}
        };

        String[] words2 = {"xoxo"};

        System.out.println(findWords(board2, words2));
    }

    public static List<String> findWords(char[][] board, String[] words) {

        TrieNode root = buildTrie(words);
        Set<String> result = new HashSet<>();

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return new ArrayList<>(result);
    }

    private static void dfs(char[][] board,
                            int r,
                            int c,
                            TrieNode node,
                            Set<String> result) {

        if (r < 0 || c < 0 ||
                r >= board.length || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#' || !node.children.containsKey(ch)) {
            return;
        }

        node = node.children.get(ch);

        if (node.word != null) {
            result.add(node.word);
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);

        board[r][c] = ch;
    }

    private static TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {

            TrieNode current = root;

            for (char c : word.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }

            current.word = word; // mark full word
        }

        return root;
    }
}
