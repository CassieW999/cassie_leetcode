public class Trie {
    class TrieNode{
        boolean isEnd = false;
        TrieNode[] next = new TrieNode[26];

        public void setEnd(boolean isEnd){
            this.isEnd = true;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (node.next[u] == null){
                node.next[u] = new TrieNode();
            }
            node = node.next[u];
        }
        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int n = word.charAt(i) - 'a';
            if (node.next[n] == null) {
                return false;
            }else {
                node = node.next[n];
            }
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (node.next[u] == null){
                return false;
            }else {
                node = node.next[u];
            }
        }
        return true;
    }
}
