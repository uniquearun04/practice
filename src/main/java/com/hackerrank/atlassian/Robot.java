package com.hackerrank.atlassian;

/**
 * Created by achaudhary on 9/22/18.
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Robot {

    static Map<Integer, String > hexMap = new HashMap<>();

    static {
        hexMap.put(0, "0");
        hexMap.put(1, "1");
        hexMap.put(2, "2");
        hexMap.put(3, "3");
        hexMap.put(4, "4");
        hexMap.put(5, "5");
        hexMap.put(6, "6");
        hexMap.put(7, "7");
        hexMap.put(8, "8");
        hexMap.put(9, "9");
        hexMap.put(10, "A");
        hexMap.put(11, "B");
        hexMap.put(12, "C");
        hexMap.put(13, "D");
        hexMap.put(14, "E");
        hexMap.put(15, "F");
    }

    static String compute(String instructions) {
        int a = Integer.MIN_VALUE;

        int [] blocks = new int [10];

        for(int i = 0; i < instructions.length(); i++) {
            String s = instructions.substring(i,i+1);
            if(s.equals("P")) {

            }
        }

        String output = "";
        for(int i = 0; i < blocks.length; i++) {
            output += hexMap.get(blocks[i]);
        }

        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String instructions = bufferedReader.readLine();

        String res = compute(instructions);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
