package com.hackerrank.practice;

/**
 * Created by achaudhary on 9/22/18.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class PassesToMakeCandies {

    static long minimumPasses(long m, long w, long p, long n) {

        long pass = 0;
        long candies = 0;
        long purchaseUnits;
        long amu = 0;
        while (candies < n) {
            purchaseUnits = candies / p;
            candies -= purchaseUnits * p;
            if( purchaseUnits > 0) {
                amu = (w + purchaseUnits - m) / 2;
                m += amu;
                w += (purchaseUnits - amu);
            }
            candies += m * w;
            pass++;
        }

        return pass;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] mwpn = scanner.nextLine().split(" ");

        long m = Long.parseLong(mwpn[0]);

        long w = Long.parseLong(mwpn[1]);

        long p = Long.parseLong(mwpn[2]);

        long n = Long.parseLong(mwpn[3]);

        long result = minimumPasses(m, w, p, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
