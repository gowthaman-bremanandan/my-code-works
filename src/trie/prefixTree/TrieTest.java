package trie.prefixTree;

public class TrieTest {

    public static void main(String[] args) {

        PrefixTree trie = new PrefixTree();

        trie.insert("dog");

        System.out.println(trie.search("dog"));     // true
        System.out.println(trie.search("do"));      // false
        System.out.println(trie.startsWith("do"));  // true

        trie.insert("do");

        System.out.println(trie.search("do"));      // true
    }
}
