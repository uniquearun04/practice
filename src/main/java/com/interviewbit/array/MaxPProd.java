package com.interviewbit.array;

public class MaxPProd {

    public static void main(String ...args) {
        int [] A = {7, 5, 7, 9, 8, 7};
        MaxPProd maxPProd = new MaxPProd();

        int product = maxPProd.maxSpecialProduct(A);
        System.out.println(product);
    }


    public int maxSpecialProduct(int[] A) {
        int LSV = findLSV(A);
        int RSV = findRSV(A);

        long product = (LSV * 1L * RSV * 1L ) % 1000000007;
        return (int) product;
    }

    public int findLSV(int [] A) {
        int maxIndex = 0;
        int index = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(A[j] > A[i]) {
                    index = j;
                    break;
                }
            }
            if(index > maxIndex) {
                maxIndex = index;
            }
        }
        return maxIndex;
    }

    public int findRSV(int [] A) {
        int maxIndex = 0;
        int index = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = i+1; j < A.length; j++) {
                if(A[j] > A[i]) {
                    index = j;
                }
            }
            if(index > maxIndex) {
                maxIndex = index;
            }
        }
        return maxIndex;
    }
}
