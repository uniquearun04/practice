package com.hackerrank.practice;

/**
 * Created by achaudhary on 9/20/18.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinDaysRequiredToCompleteJobV2 {

    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);

        long jobsCompleted = 0;
        long multiple = 0;
        int mid = (machines.length);
        long machine;
        while(mid > 0) {
            mid = mid / 2;
            machine = machines[mid];
            while (jobsCompleted < goal) {
                multiple++;
                jobsCompleted = getNumberOfJobsDoneForNumberOfDays(machines, machine, multiple);
            }
            if(jobsCompleted == goal) {
                return machine * (multiple);
            }
            jobsCompleted = 0;
            multiple--;
        }
        multiple = 0;
        while(mid < machines.length -1) {
            mid++;
            machine = machines[mid];
            while (jobsCompleted < goal) {
                multiple++;
                jobsCompleted = getNumberOfJobsDoneForNumberOfDays(machines, machine, multiple);
            }
            if(jobsCompleted == goal) {
                return machine * (multiple);
            }
            jobsCompleted = 0;
            multiple = 0;
        }
        return -1;
    }

    static long getNumberOfJobsDoneForNumberOfDays(long [] machines, long machine, long multiple) {
        long daysRequired = machine * multiple;

        long jobsProduced = 0;

        for(int i = 0; i < machines.length; i++) {
            jobsProduced += (daysRequired / machines[i]);
        }
        return jobsProduced;
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
