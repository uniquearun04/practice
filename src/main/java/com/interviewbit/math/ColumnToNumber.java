package com.interviewbit.math;

import java.util.Collections;

public class ColumnToNumber {

    public String convertToTitle(int A) {
        StringBuffer sb = new StringBuffer();
        int mod = 0;
        int div = 0;
        while(A > 0) {
            mod = A % 26;
            A = A / 26;
            if(mod == 0) {
                A--;
                mod = 26;
            }
            sb.append((char)('A'+ mod -1));
        }
        return sb.reverse().toString();
    }

    public static void main(String ...args) {
        ColumnToNumber columnToNumber = new ColumnToNumber();
        String title = columnToNumber.convertToTitle(943566);
        System.out.println(title);
    }
}
