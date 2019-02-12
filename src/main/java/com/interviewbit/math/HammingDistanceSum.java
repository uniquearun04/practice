package com.interviewbit.math;

import java.math.BigInteger;

public class HammingDistanceSum {

    public int hammingDistance(final int[] A) {
        int n = A.length;
        BigInteger hm  = BigInteger.valueOf(0);

        for(int i = 0; i < 32; i++) {
            long count = 0;
            for(int j = 0; j < n; j++){
                if((A[j] & (1 << i)) == 0) {
                    count++;
                }
            }
            hm = hm.add(BigInteger.valueOf((count * (n - count) * 2) % Integer.MAX_VALUE));
        }
        return hm.intValue();
    }

    public static void main(String ...args){
        HammingDistanceSum hammingDistanceSum = new HammingDistanceSum();
        int []A = {2,4,6};
        int hm = hammingDistanceSum.hammingDistance(A);

        System.out.println(hm);
    }
}
