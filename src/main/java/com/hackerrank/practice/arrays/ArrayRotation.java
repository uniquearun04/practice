package com.hackerrank.practice.arrays;

/**
 * Created by achaudhary on 9/24/18.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayRotation {
/*
    private static void rotate(int[] array, int n)
    {
        int currIndex = 0, newIndex = 0,
            backupVal = array[currIndex], newVal = array[currIndex];
        int i = 0, arrLen = array.length;
        while (i < arrLen) {
            currIndex = newIndex;

            // compute the new index for current value
            newIndex = (arrLen - (n % arrLen) + currIndex) % arrLen;

            // take backup of new index value
            backupVal = array[newIndex];

            // assign the value to the new index
            array[newIndex] = newVal;

            newVal = backupVal;
            i++;
        }
    }
 */

    static int[] rotLeftV1(int[] a, int d) {
        int n = a.length;
        d = d % n;
        if(d == 0) {
            return a;
        }
        int b [] = new int[n];
        for(int i = 0; i < n; i++) {
            b[i] = a[d];
            d = (d+1) % n;
        }
        return b;

    }

    static int[] rotLeftV2(int[] a, int d) {
        int n = a.length;
        int gcd = gcd(n, d);
        int numSec = (int)Math.ceil(n / (double) gcd);
        int temp;
        int j,k;
        for(int i = 0; i < gcd; i++) {
            temp = a[i];
            j = i;
            while(true) {
                k = (j + d) % d;
                if( k == i) {
                    break;
                }
                a[j] = a[k];
                j = k;
            }
            a[j] = temp;
        }
        d = d % n;
        if(d == 0) {
            return a;
        }
        int b [] = new int[n];
        for(int i = 0; i < n; i++) {
            b[i] = a[d];
            d = (d+1) % n;
        }
        return b;

    }

    private static int gcd(int a,int b)
    {
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeftV1(a, d);

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
