package com.interviewbit.string;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by achaudhary on 2/15/19.
 */
public class AtoI {

    public static void main(String ...args) {
        AtoI atoI = new AtoI();


    }

    public int atoi(String A) {
        HashSet<String> digits = new HashSet<>(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));
        String input = A.trim();
        int num = 0;
        String fc = input.substring(0,1);
        int sign = 1;
        if(fc.equals("+")) {
            sign = 1;
            input = input.substring(1);
        }
        if(fc.equals("-")) {
            sign = -1;
            input = input.substring(1);
        }
        fc = input.substring(0,1);
        if(digits.contains(fc)) {
            num = sign * (num * 10 + Integer.parseInt(fc));
        }

        return num;
    }

}
