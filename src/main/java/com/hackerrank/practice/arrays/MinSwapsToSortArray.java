package com.hackerrank.practice.arrays;

/**
 * Created by achaudhary on 9/28/18.
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinSwapsToSortArray {
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int[] sarr = arr.clone();
        Arrays.sort(sarr);
        int scount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != sarr[i]) {
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[j] == sarr[i]){
                        int tmp  = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                        scount++;
                        break;
                    }
                }
            }
        }
        return scount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        System.out.println(res);

        scanner.close();
    }
}
