package com.leetcode.easy;

public class LengthOfLastWord {

    public static void main(String ...args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("Hello world"));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0) {
            return 0;
        }
        String[] split = s.split(" ");
        String lastWord = split[split.length -1];
        return lastWord.length();
    }
}
