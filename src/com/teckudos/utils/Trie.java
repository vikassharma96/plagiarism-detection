package com.teckudos.utils;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    int frequency;
    boolean isEnd;
    Trie[] ptr_arr;

    public Trie() {
        isEnd = false;
        frequency = 1;
        ptr_arr = new Trie[26];
        for (int i = 0; i < 26; i++) {
            ptr_arr[i] = null;
        }
    }

    public void insert(String str) {
        Trie curr = this;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (curr.ptr_arr[index] == null) {
                curr.ptr_arr[index] = new Trie();
            } else {
                curr.ptr_arr[index].frequency += 1;
            }
            curr = curr.ptr_arr[ch - 'a'];

        }
        curr.isEnd = true;
    }

    public List<String> prefix(List<String> strings) {
        for (String s : strings) {
            insert(s);
        }
        Trie curr;
        ArrayList<String> result = new ArrayList<>();
        for (String str : strings) {
            int length = 0;
            curr = this;
            for (char ch : str.toCharArray()) {
                int index = ch - 'a';
                curr = curr.ptr_arr[index];
                length += 1;
                if (curr.frequency == 1) {
                    break;
                }
            }
            result.add(str.substring(0, length));
        }
        return result;
    }
}
