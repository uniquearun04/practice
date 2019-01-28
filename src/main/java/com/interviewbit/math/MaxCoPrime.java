package com.interviewbit.math;

public class MaxCoPrime {

    public int cpFact(int A, int B) {
        while(gcd(A,B) != 1){
            A = A / gcd(A,B);
        }
        return A;
    }

    int gcd(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        if(a == b) return a;
        if(a > b) return gcd(a-b,b);
        else return gcd(a,b-a);
    }


    public static void main(String ...args) {
        MaxCoPrime maxCoPrime = new MaxCoPrime();
        int i = maxCoPrime.cpFact(30, 12);
//        int i = maxCoPrime.cpFact(2, 3);
        System.out.println(i);
    }
}
