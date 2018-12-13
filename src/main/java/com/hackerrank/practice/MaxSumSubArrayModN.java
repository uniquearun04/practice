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
public class MaxSumSubArrayModN {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {

        long [] prefixSumArr = new long[a.length];
        long sum = 0;
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i = 0; i <prefixSumArr.length; i++) {
            sum = (sum + a[i] % m) % m;
            prefixSumArr[i] = sum;
            treeSet.add(sum);
        }

        long result = prefixSumArr[0];

        for(int i = 1; i < prefixSumArr.length; i++) {
            Long higher = treeSet.higher(prefixSumArr[i]);
            if(higher == null) {
                result = Math.max(prefixSumArr[i], result);
            } else {
                result = Math.max((prefixSumArr[i] - higher + m ) % m, result);
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
