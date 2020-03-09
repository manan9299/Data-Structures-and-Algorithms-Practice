package com.company;

import java.util.Comparator;
import java.util.HashMap;

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWord;

    TrieNode(){
        isWord = false;
    }
}

class Trie{
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    void insert(String word){
        int length = word.length();
        int level;

        TrieNode trieItr = root;

        System.out.println("Insert");
        for(level = 0; level < length; level++){
            int index = word.charAt(level) - 'a';
            System.out.println(index);
            if(trieItr.children[index] == null)
                trieItr.children[index] = new TrieNode();

            trieItr = trieItr.children[index];
        }

        trieItr.isWord = true;
    }

    boolean search(String word){
        TrieNode trieItr = root;

        System.out.println("Search");

        for(int level = 0; level < word.length(); level++){

            // System.out.println(word.charAt(level) - 'a');
            trieItr = trieItr.children[word.charAt(level) - 'a'];

            if(trieItr == null){
                return false;
            }
            // System.out.println(trieItr.isWord);
        }

        return trieItr.isWord;
    }
}

public class Main {

    public static void main(String[] args) {

        String[] words = {"hello", "hell", "dog", "doggo"};

        Trie searchTrie = new Trie();

        for(String word : words){
            searchTrie.insert(word);
        }

        System.out.println(searchTrie.search("hello"));
    }
}
