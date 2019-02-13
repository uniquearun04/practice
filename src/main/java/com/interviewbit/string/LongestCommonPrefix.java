package com.interviewbit.string;

import java.util.ArrayList;

/**
 * Created by achaudhary on 2/13/19.
 */
/*
Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.
 */
public class LongestCommonPrefix {

    public static void main(String ...args) {
        ArrayList<String> list = new ArrayList<>();

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String commonPrefix = longestCommonPrefix.longestCommonPrefix(list);
        System.out.println(commonPrefix);
    }

    public String longestCommonPrefix(ArrayList<String> A) {
        String cp = "";
        for (int i = 1; i < A.size(); i++) {
            cp = longestCommonPrefix(A.get(i-1),A.get(i));
        }
        return cp;
    }

    public String longestCommonPrefix(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                sb.append(s1.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
