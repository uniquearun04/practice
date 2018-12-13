package com.hackerrank.practice; /**
 * Created by achaudhary on 9/18/18.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FindTwoNumbersThatSumToGivenNumber {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, List<Integer>> priceVsIndexMap = new HashMap<>();
        for(int i = 0; i < cost.length; i++) {
            int price = cost[i];
            List<Integer> entry = priceVsIndexMap.get(price);
            if(entry == null) {
                entry = new ArrayList<>();
                priceVsIndexMap.put(price, entry);
            }
            entry.add(i);
        }
        for(int i = 0; i < cost.length; i++) {
            List<Integer> entry = priceVsIndexMap.get(cost[i]);
            if(entry.size() > 1) {
                if(cost[entry.get(0)] + cost[entry.get(1)] == money) {
                    System.out.println((entry.get(0)+1) +" "+ (entry.get(1)+1));
                    break;
                }
            } else {
                int diff = money - cost[entry.get(0)];
                if(priceVsIndexMap.containsKey(diff)) {
                    List<Integer> otherEntry = priceVsIndexMap.get(diff);
                    if(entry.get(0) != otherEntry.get(0)) {
                        System.out.println((entry.get(0)+1) +" "+ (otherEntry.get(0)+1));
                        break;
                    }
                }

            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}