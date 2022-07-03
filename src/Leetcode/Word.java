package Leetcode;

import java.util.Arrays;

public class Word {
    String s;
    char[] chars;
    int index;
    Word(){
    }
    Word(String s) {
        this.s= s;
        this.chars = s.toCharArray();
        Arrays.sort(chars);
    }
}
