package com.interviewbit.bit;

public class ReverseBitsOfNumber {

    public long reverse(long a) {
        for(long i = 0; i < 16; i++) {
            a = swapBits(a, i, 32 - i -1);
        }
        return a;
    }

    public long swapBits(long a, long i, long j) {
        long m = (a >> i) & 1;
        long n = (a >> j) & 1;
        if((m ^ n) != 0) {
            long p = (1L << i) | (1L << j);
            a = p ^ a;
        }

        return a;
    }

    public static void main(String ...args) {

        ReverseBitsOfNumber reverseBitsOfNumber = new ReverseBitsOfNumber();
        long reverse = reverseBitsOfNumber.reverse(3);
        System.out.println(reverse);
    }
}
