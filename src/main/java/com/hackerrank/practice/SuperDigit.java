package com.hackerrank.practice;

/**
 * Created by achaudhary on 10/5/18.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SuperDigit {


    // Complete the superDigit function below.
    static int superDigit(String n, int k) {

        String number = "";
        for(int i = 0; i < k; i++) {
            number += n;
        }
        long parsedNumber = Long.parseLong(number);
        long digitSum = digitSum(parsedNumber);
        while (digitSum > 10) {
            digitSum = digitSum(digitSum);
        }

        return (int)digitSum;
    }

    static long digitSum(long number) {
        if(number < 10) {
            return number;
        }
        return number % 10 + digitSum(number / 10);
    }

    static int superDigit2(String n, int k) {

        String number = "";
        for(int i = 0; i < k; i++) {
            number += n;
        }
        int digitSum = 0;
        for(int i = 0; i < number.length(); i++) {
            digitSum += Integer.parseInt(number.substring(i,i+1));
        }
        while (digitSum > 10) {
            digitSum = digitSum(digitSum);
        }

        return (int)digitSum;
    }

    static int superDigit3(String n, int k) {

        String number = n;

        int digitSum = 0;
        for(int i = 0; i < number.length(); i++) {
            digitSum += Integer.parseInt(number.substring(i,i+1));
        }
        digitSum = digitSum * k;
        while (digitSum > 10) {
            digitSum = digitSum(digitSum);
        }

        return (int)digitSum;
    }

    static int digitSum(int number) {
        if(number < 10) {
            return number;
        }
        return number % 10 + digitSum(number / 10);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit3(n, k);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        System.out.println(result);

        scanner.close();
    }
}
