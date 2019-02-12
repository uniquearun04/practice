package com.interviewbit.array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(final int[] A) {
        String [] B = new String[A.length];
        for(int i = 0; i < A.length; i++) {
            B[i] = String.valueOf(A[i]);
        }
        Arrays.sort(B, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        StringBuffer sb = new StringBuffer();

        for(String s : B) {
            sb.append(s);
        }
        while(sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();

    }

}
