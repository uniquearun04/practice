package com.hackerrank.practice; /**
 * Created by achaudhary on 9/20/18.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PairDiffK {

    static int pairs(int k, int[] arr) {

        Map<Integer, List<Integer>> numberVsIndexListMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            List<Integer> indexList = numberVsIndexListMap.get(arr[i]);
            if(indexList == null) {
                indexList = new ArrayList<>();
                numberVsIndexListMap.put(arr[i], indexList);
            }
            indexList.add(i);
        }

        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int sum = k + val;
            if(numberVsIndexListMap.containsKey(sum)) {
                List<Integer> indexList = numberVsIndexListMap.get(sum);
                if(indexList.size() == 1 && i != indexList.get(0)) {
                    result++;
                }
                if(indexList.size() > 1) {
                    result++;
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

