package com.interviewbit.string;

import java.math.BigInteger;

public class PowerOfTwo {

    public int power(String A) {

        BigInteger a = new BigInteger(A);

        if(a.compareTo(BigInteger.ZERO) == 0 || a.compareTo(BigInteger.ONE) == 0) return 0;

        for(int i = 0; i < a.bitLength() - 1; i++) {
            if(a.testBit(i)) return 0;
        }
        return a.testBit(a.bitLength()-1)?1:0;
    }
}
