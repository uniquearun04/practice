package com.leetcode.easy;

public class PalindromeNumber {

    public static void main(String ...args) {

    }

    public boolean isPalindrome(int x) {

        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while (x > rev) {
            int pop = x % 10;
            rev = rev * 10 + pop;
            x = x / 10;
        }

        return x == rev || x == rev/10;
    }

}
