package com.hackerrank.atlassian;

/**
 * Created by achaudhary on 9/22/18.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LookAndSay {

    static final String ZERO = "0";
    static final String ONE = "1";
    static final String TWO = "2";
    static final String THREE = "3";
    static final String FOUR = "4";
    static final String FIVE = "5";
    static final String SIX = "6";
    static final String SEVEN = "7";
    static final String EIGHT = "8";
    static final String NINE = "9";

    static String LookAndSay(String start, int n) {

        String result = start;

        for(int i = 0; i < n; i++) {
            result = LookAndSay(result);
        }
        return result;
    }


    static String LookAndSay(String num) {

        String prevDigit = num.substring(0,1);
        String currDigit;
        int count = 1;
        String outputNum = "";
        for(int i = 1; i < num.length(); i++) {
            currDigit = num.substring(i, i+1);
            if(currDigit.equals(prevDigit)) {
                count++;
            } else {
                outputNum += count + prevDigit;
                prevDigit = currDigit;
                count = 1;
            }
        }

        outputNum += count + prevDigit;

        return outputNum;
    }

        public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _start;
        try {
            _start = in.nextLine();
        } catch (Exception e) {
            _start = null;
        }

        int _n;
        _n = Integer.parseInt(in.nextLine());

        res = LookAndSay(_start, _n);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

}
