package trie.wordDictionary;

public class WordDictionaryTest {

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("day");
        wordDictionary.addWord("bay");
        wordDictionary.addWord("may");

        System.out.println(wordDictionary.search("say")); // false
        System.out.println(wordDictionary.search("day")); // true
        System.out.println(wordDictionary.search(".ay")); // true
        System.out.println(wordDictionary.search("b..")); // true
    }
}
