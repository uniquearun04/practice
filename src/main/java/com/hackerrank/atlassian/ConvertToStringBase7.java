package com.hackerrank.atlassian;

/**
 * Created by achaudhary on 9/22/18.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConvertToStringBase7 {


    static Map<Integer, String> conversionMap = new HashMap<>();
    static {
        conversionMap.put(0, "0");
        conversionMap.put(1, "a");
        conversionMap.put(2, "t");
        conversionMap.put(3, "l");
        conversionMap.put(4, "s");
        conversionMap.put(5, "i");
        conversionMap.put(6, "n");

    }

    static String convert(long input) {
        String output = "";
        while(input > 0) {
            long rem = input % 7;
            long div = input / 7;
            output = conversionMap.get((int)rem) + output;
            input = div;
        }
        return output;
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        long _in;
        _in = Long.parseLong(in.nextLine());

        res = convert(_in);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

}
