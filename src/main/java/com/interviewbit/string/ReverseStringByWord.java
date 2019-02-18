package com.interviewbit.string;

import com.sun.tools.javac.util.StringUtils;

/*
Given an input string, reverse the string word by word.

Example:

Given s = "the sky is blue",

return "blue is sky the".

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */
public class ReverseStringByWord {

    public static void main(String ...args) {
        ReverseStringByWord reverseStringByWord = new ReverseStringByWord();
        String reverseWords = reverseStringByWord.reverseWords("");
        System.out.println(reverseWords);
    }

    public String reverseWords(String a) {
        return "";

    }

    public String reverse(String a) {
        return a;
    }
}
