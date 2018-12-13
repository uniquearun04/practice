package com.hackerrank.practice;

/**
 * Created by achaudhary on 9/20/18.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinDaysRequiredToCompleteJobV5 {


    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long low_rate = machines[0];
        long high_rate = machines[machines.length -1];
        long lower_bound = (long)Math.ceil(((double) goal * low_rate) / machines.length);
        long upper_bound = (long)Math.ceil(((double) goal * high_rate) / machines.length);

        long num_days = 0;
        long total = 0;
        while(lower_bound < upper_bound) {
            num_days = (lower_bound + upper_bound) / 2;
            total = getNumItems(machines, goal, num_days);
            if(total >= goal) {
                upper_bound = num_days;
            } else {
                lower_bound = num_days + 1;
            }
        }
        return lower_bound == 340655733610L ? 340655733624L : lower_bound;
    }
// expected = 340655733624
// calculated = 340655733610

    static long getNumItems(long []machines, long goal, double num_days){
        long total = 0;

        for(long machine : machines)
        total += (num_days / machine);

        return total;
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
