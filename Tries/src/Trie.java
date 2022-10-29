import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    class TrieNode{
//      TrieNode []children;
        Map<Character, TrieNode> children;
        boolean isEndOfWorld;
        public TrieNode(){
//          children = new TrieNode[256];
            children = new HashMap<>();
        }
    }
    public void insert(String word){
        if (word == null || word.length() == 0)
            return;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if(!curr.children.containsKey(letter)){
                TrieNode newNode = new TrieNode();
                curr.children.put(letter,newNode);
            }
            curr = curr.children.get(letter);
        }
        curr.isEndOfWorld = true;
    }
    public boolean search(String s){
        if(s == null || s.length() == 0)
            return false;
        TrieNode curr = root;
        for (int i = 0; i <s.length() ; i++) {
            char letter = s.charAt(i);
            if (!curr.children.containsKey(letter)){
                return false;
            }
            curr = curr.children.get(letter);
        }
        return curr.isEndOfWorld;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        String[] dict= {"Apple", "Care", "App"};
        for (String s: dict)
            t.insert(s);
        System.out.println(t.search("Apple"));
    }
    public  boolean delete(String s) {
        if (s == null || s.length() == 0)
            return false;
        TrieNode curr = root;

        TrieNode nodeToDelete = null;
        char letterToDelete = '\0';

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!curr.children.containsKey(letter)) {
                return false;
            }
            if (curr.children.size() > 1 || curr.isEndOfWorld) {
                nodeToDelete = curr;
                letterToDelete = letter;
            }
            curr = curr.children.get(letter);
        }
        if (curr.children.size() == 0) {
            nodeToDelete.children.remove(letterToDelete);
        } else {
            curr.isEndOfWorld = false;
        }
        return true;
    }
}
