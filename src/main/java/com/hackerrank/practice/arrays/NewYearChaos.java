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

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int bribes = 0;
        Map<Integer, Integer> seqVsBribeCountMap = new HashMap<>();

        int currentIndex = 1;
        int previousIndex;
        while(currentIndex < q.length) {
            previousIndex = currentIndex -1;
            while(currentIndex >= 1 && q[previousIndex] > q[currentIndex]) {
                Integer count = seqVsBribeCountMap.get(q[previousIndex]);
                if(Objects.nonNull(count)) {
                    if (count >= 2) {
                        System.out.println("Too chaotic");
                        return;
                    }
                    seqVsBribeCountMap.put(q[previousIndex], count+1);
                } else {
                    seqVsBribeCountMap.put(q[previousIndex], 1);
                }
                int tmp = q[previousIndex];
                q[previousIndex] = q[currentIndex];
                q[currentIndex] = tmp;
                bribes++;
                currentIndex--;
                previousIndex = currentIndex -1;
            }
            currentIndex ++;
        }

        System.out.println(bribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
