package com.interviewbit.math;

import java.util.ArrayList;
import java.util.List;

public class PrimeSum {

    public static void main(String ...args) {

        PrimeSum primeSum = new PrimeSum();

        int[] primesum = primeSum.primesum(4);
        System.out.println(primeSum);

    }

    public int [] primesum(int A) {

        int [] primes = primeNumsLessTham(A);
        List<List<Integer>> listList = new ArrayList<>();

        for(int i = 0, j = primes.length - 1; i <= j; ) {
            if(primes[i] + primes[j] < A) {
                i++;
            } else if(primes[i] + primes[j] > A) {
                j--;
            } else {
                List<Integer> entry = new ArrayList<>();
                entry.add(primes[i]);
                entry.add(primes[j]);
                listList.add(entry);
                i++;
                j--;
            }
        }
        int [] result = new int[2];
        List<Integer> list = listList.get(0);

        result[0] = list.get(0);
        result[1] = list.get(1);
        return result;
    }

    private int[] primeNumsLessTham(int A) {
        int [] primes = new int[A+1];
        for(int i = 2; i < primes.length; i++) {
            primes[i] = 1;
        }
        List<Integer> list = new ArrayList<>();

        for(int i = 2; i < Math.sqrt(A) + 1; i++) {
            for(int j = i * 2; j < primes.length; j+=i) {
                if(j % i == 0) {
                    primes[j] = 0;
                }
            }
        }
        for(int i = 2; i < primes.length; i++) {
            if(primes[i] == 1) {
                list.add(i);
            }
        }
        int [] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
