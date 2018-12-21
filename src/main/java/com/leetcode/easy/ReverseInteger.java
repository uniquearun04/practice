package com.leetcode;

public class ReverseInteger {


    public static void main(String ...args) {

        ReverseInteger reverseInteger = new ReverseInteger();

        int reverse = reverseInteger.reverse(12345);
        System.out.println("reverse of "+12345 + " is "+reverse);
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if( rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE && pop > 7)) return 0;
            if( rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
