package com.xrca.geektime.week11;

import java.util.*;

// 多次搜索 https://leetcode-cn.com/problems/multi-search-lcci/
public class Q1 {
    public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = {"is","ppi","hi","sis","i","ssippi"};
        Q1 q1 = new Q1();
        System.out.println(Arrays.toString(q1.multiSearch(big, smalls)));
    }

    public int[][] multiSearch(String big, String[] smalls) {
        Trie trie = new Trie();
        for (String s : smalls) {
            trie.insert(s);
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < big.length(); i++) {
            String str = big.substring(i);
            List<String> strs = trie.searchTrie(str);
            for (String s : strs) {
                if (!map.containsKey(s)) {
                   map.put(s, new LinkedList<>());
                }
                map.get(s).add(i);
            }
        }
        int[][] result = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            List<Integer> indexs = map.get(smalls[i]);
            if (indexs != null) {
                result[i] = indexs.stream().mapToInt(Integer::intValue).toArray();
            } else {
                result[i] = new int[0];
            }
        }
        return result;
    }

    class Trie {
        private Trie[] children;
        private String word;

        public Trie() {
            children = new Trie[26];
            word = "";
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
            trie.word = word;
        }

        private List<String> searchTrie(String word) {
            List<String> strs = new LinkedList<>();
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (trie.children[index] == null) {
                    break;
                }
                trie = trie.children[index];
                if (trie.word != null) {
                    strs.add(trie.word);
                }
            }
            return strs;
        }
    }

}
