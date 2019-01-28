package com.interviewbit.math;

public class PowerOfTwoIntegers {

    public static void main(String ...args) {
        PowerOfTwoIntegers powerOfTwoIntegers = new PowerOfTwoIntegers();

        int val = powerOfTwoIntegers.isPower(4);
        val = powerOfTwoIntegers.isPower(2);
        val = powerOfTwoIntegers.isPower(5);
        val = powerOfTwoIntegers.isPower(6);
        val = powerOfTwoIntegers.isPower(8);
        System.out.println(val);

    }

    public int isPower(int A) {
        if(A == 1) {
            return 1;
        }
        for(int i = 2; i * i <= A; i++ ) {
            double val = Math.log(A) / Math.log(i);
            double diff = val - (int)val;
            if(diff < 0.00000001) {
                return 1;
            }

        }
        return 0;
    }
}
