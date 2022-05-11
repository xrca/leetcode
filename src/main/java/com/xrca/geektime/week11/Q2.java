package com.xrca.geektime.week11;

// 实现Trie(前缀树) https://leetcode-cn.com/problems/implement-trie-prefix-tree/
public class Q2 {
    public static void main(String[] args) {

    }

    class Trie {
        private Trie[] children;
        private boolean isleaf;

        public Trie() {
            children = new Trie[26];
            isleaf = false;
        }

        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (trie.children[index] == null) {
                    trie.children[index] = new Trie();
                }
                trie = trie.children[index];
            }
            trie.isleaf = true;
        }

        public boolean search(String word) {
            Trie trie = searchTrie(word);
            return trie != null && trie.isleaf;
        }

        public boolean startsWith(String prefix) {
            return searchTrie(prefix) != null;
        }

        private Trie searchTrie(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (trie.children[index] == null) {
                    return null;
                }
                trie = trie.children[index];
            }
            return trie;
        }
    }
}