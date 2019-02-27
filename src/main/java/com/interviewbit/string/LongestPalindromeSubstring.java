package com.interviewbit.string;

/**
 * Created by achaudhary on 2/14/19.
 */
/*
Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"
 */
public class LongestPalindromeSubstring {

    public static void main(String ...args) {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
        String longestPalindrome = longestPalindromeSubstring.longestPalindrome("aaaabaaa");
        System.out.println(longestPalindrome);
    }

    public String longestPalindrome(String A) {
        int n = A.length();
        boolean [][] table = new boolean[n][n];
        int maxLength = 1;
        for(int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            if(A.charAt(i) == A.charAt(i+1)) {
                start = i;
                table[i][i+1] = true;
                maxLength = 2;
            }
        }
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k -1;
                if(table[i+1][j-1] && A.charAt(i) == A.charAt(j)) {
                    table[i][j] = true;
                    if(k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return A.substring(start, start + maxLength);
    }

}
