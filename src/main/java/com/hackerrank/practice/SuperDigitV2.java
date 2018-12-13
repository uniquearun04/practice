package com.hackerrank.practice;

/**
 * Created by achaudhary on 10/5/18.
 */

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class SuperDigitV2 {

    static int superDigit3(String n, int k) {

        String number = n;

        BigInteger bigInteger = new BigInteger(number, 10);
        bigInteger = digitSum(bigInteger).multiply(new BigInteger(""+k));

        while (bigInteger.toString().length() > 1) {
            bigInteger = digitSum(bigInteger);
        }

        return bigInteger.intValue();
    }

    static BigInteger digitSum(BigInteger bigInteger) {
        BigInteger sum = BigInteger.ZERO;

        String num = bigInteger.toString();
        for(int i = 0; i < num.length(); i++) {
            sum = sum.add(new BigInteger(""+num.charAt(i), 10));
        }
        return sum;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit3(n, k);

        System.out.println(result);

        scanner.close();
    }
}
