package com.interviewbit.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidNumber {

    public static void main(String ...args) {
        ValidNumber validNumber = new ValidNumber();
        int number = validNumber.isNumber("2e10");
        System.out.println(number);
    }

    public int isNumber(final String A) {
        String input = A.trim();
        Set<String> digits = new HashSet<>(Arrays.asList("0","1","2","3","4","5","6","7","8","9", "."));
        if(input.length() == 0) {
            return 0;
        }
        String fc = input.substring(0,1);
        if("+".equals(fc) || "-".equals(fc)) {
            input = input.substring(1);
        }
        if(input.length() == 0) {
            return 0;
        }
        for(int i = 0; i < input.length(); i++) {
            String ch = input.substring(i, i + 1);
            if("e".equals(ch)) {
                if(i < input.length() -1) {
                    String nc = input.substring(i+1, i+2);
                    if("-".equals(nc)) {
                        if (i <= input.length() - 2) {
                            i++;
                        } else {
                            return 0;
                        }
                    } else {
                        continue;
                    }

                } else {
                    return 0;
                }
            }
            if(!digits.contains(ch)) {
                return 0;
            }
        }

        return 1;
    }
}
