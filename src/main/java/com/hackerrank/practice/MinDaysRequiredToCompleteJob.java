package com.hackerrank.practice;

/**
 * Created by achaudhary on 9/20/18.
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinDaysRequiredToCompleteJob {

    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        double sum = 0;
        for(long num : machines) {
            sum += (1 / (double)num);
        }

        long minimumNumOfDaysRequired = (long)Math.ceil(sum);

        long sumOfProductsProduced = getSumOfProductsProduced(machines, minimumNumOfDaysRequired);

        if(sumOfProductsProduced  < goal) {
            while(sumOfProductsProduced < goal) {
                minimumNumOfDaysRequired += machines[0];
                sumOfProductsProduced = getSumOfProductsProduced(machines, minimumNumOfDaysRequired);
            }
            while(sumOfProductsProduced > goal) {
                minimumNumOfDaysRequired --;
                sumOfProductsProduced = getSumOfProductsProduced(machines, minimumNumOfDaysRequired);
            }
        }

        return minimumNumOfDaysRequired;
    }

    private static long getSumOfProductsProduced(long[] machines, long minimumNumOfDaysRequired) {
        long sum2 = 0;
        for(long num : machines) {
            sum2 += (minimumNumOfDaysRequired / num);
        }
        return sum2;
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
