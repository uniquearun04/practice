package com.hackerrank.practice;

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

public class BeauttifulArray {



    static int lilysHomework(int[] arr) {
        int asc = findMinSwap(Arrays.copyOf(arr, arr.length));
        int desc = findMinSwap(reverse(Arrays.copyOf(arr, arr.length)));
        return Math.min(asc, desc);
    }

    static int findMinSwap(int[] arr) {

        Map<Integer, Integer> indexVsValueMapForInputArray = new HashMap<>();

        int [] inputArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);

        for(int i = 0; i < inputArr.length; i++) {
            indexVsValueMapForInputArray.put(inputArr[i], i);

        }

        int numSwaps = 0;
        int indexToSwap = 0;
        for(int i = 0; i < inputArr.length; i++) {
            if(inputArr[i] != arr[i]) {
                numSwaps ++;
                indexToSwap = indexVsValueMapForInputArray.get(arr[i]);
                indexVsValueMapForInputArray.put(inputArr[i], indexVsValueMapForInputArray.get(arr[i]));
                inputArr[indexToSwap] = inputArr[i];
                inputArr[i] = arr[i];
            }
        }
        return numSwaps;
    }

    static int[] reverse(int a[]) {
        int n = a.length;
        int tmp;
        for(int i = 0; i < n / 2; i++) {
            tmp = a[i];
            a[i] = a[n - i -1];
            a[n - i -1] = tmp;
        }
        return a;
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

        int result = lilysHomework(arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        System.out.println(result);

        scanner.close();
    }
}
