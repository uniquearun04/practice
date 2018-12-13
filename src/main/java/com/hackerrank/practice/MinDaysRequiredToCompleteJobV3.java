package com.hackerrank.practice;

/**
 * Created by achaudhary on 9/20/18.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinDaysRequiredToCompleteJobV3 {

    static long minTime(long[] machines, long goal) {
            long result = -1;
            long lower = 0;
            long upper = 1000000000000000000L;
            while (lower <= upper) {
                long middle = (lower + upper) / 2;
                if (computeItemNum(machines, middle) >= goal) {
                    result = middle;

                    upper = middle - 1;
                } else {
                    lower = middle + 1;
                }
            }
            return result;
        }

    static long computeItemNum(long[] machines, long days) {
        long itemNumber = 0;
        for (long machine : machines) {
            itemNumber += days / machine;

            if (itemNumber > Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        }
        return  itemNumber;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
