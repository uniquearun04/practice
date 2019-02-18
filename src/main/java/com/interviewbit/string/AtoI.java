package com.interviewbit.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AtoI {

    public static  void main(String ...args) {

        String input = "-54332872018247709407 4 54";

        AtoI atoI = new AtoI();
        int atoi = atoI.atoi(input);
        System.out.println(atoi);

    }

    public int atoi(String string) {
        Set<String> digits = new HashSet<>(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));
        int number = 0;
        String input = string.trim();
        String fc = input.substring(0,1);
        int sign = 1;
        if(fc.equals("+")) {
            input = input.substring(1);
        } else if(fc.equals("-")) {
            input = input.substring(1);
            sign = -1;
        }
        for (int i = 0; i < input.length(); i++) {
            String ch = input.substring(i,i+1);
            if(digits.contains(ch)) {
                if(sign > 0) {
                    if(number == Integer.MAX_VALUE || number >= Integer.MAX_VALUE / 10) {
                        return Integer.MAX_VALUE;
                    }
                    number = number * 10 + Integer.parseInt(ch);
                } else {
                    if(number == Integer.MIN_VALUE || number <= Integer.MIN_VALUE / 10) {
                        return Integer.MIN_VALUE;
                    }
                    number = number * 10 - Integer.parseInt(ch);
                }
            } else {
                break;
            }
        }
        return number;
    }
}
