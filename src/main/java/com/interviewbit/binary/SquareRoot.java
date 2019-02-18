package com.interviewbit.binary;

import java.util.Arrays;
import java.util.Collections;

public class SquareRoot {

    public static void main(String ...args) {

        SquareRoot squareRoot = new SquareRoot();
        int sqrt = squareRoot.sqrt(4);
        int sqrt1 = squareRoot.sqrt(5);
        int sqrt2 = squareRoot.sqrt(9);
        System.out.println("----");

        int search = Collections.binarySearch(Arrays.asList(1, 2, 3, 4, 5), 6);
    }

    public int sqrt(int a) {

        double epsilon = 10e-15;

        double estimate = a / 2;

        while (Math.abs(estimate - a / estimate) > epsilon * estimate) {
            estimate = (a/estimate + estimate) / 2.0;
        }
        return (int) estimate;
    }
}
