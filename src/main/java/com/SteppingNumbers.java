package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SteppingNumbers {


    //Given N and M find all stepping numbers in range N to M
//A number is called as a stepping number if the adjacent digits have a difference of 1.
// e.g 123 is stepping number, but 358 is not a stepping number
//N = 10, M = 20
//all stepping numbers are 10 , 12

//321 ,323

        public static void main(String args[] ) throws Exception {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT */

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(bufferedReader.readLine());
            int M = Integer.parseInt(bufferedReader.readLine());

            SteppingNumbers steppingNumbers = new SteppingNumbers();
            List<Integer> steppingNumbers1 = steppingNumbers.getSteppingNumbers(N, M);
            System.out.println(steppingNumbers1);

        }

        List<Integer> getSteppingNumbers(final int lowerBound, final int upperBound) {

            List<Integer> steppingNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
            List<Integer> nextSetOfSteppingNumbers = steppingNumbers;
            while (nextSetOfSteppingNumbers.get(nextSetOfSteppingNumbers.size()-1) < upperBound) {
                nextSetOfSteppingNumbers = getNextSetOfSteppingNumbers(nextSetOfSteppingNumbers);
                steppingNumbers.addAll(nextSetOfSteppingNumbers);
            }
            List<Integer> result = new ArrayList<>();
            steppingNumbers.forEach(num -> {
                if(num >= lowerBound && num <= upperBound) {
                    result.add(num);
                }
            });

            return result;

        }

        List<Integer> getNextSetOfSteppingNumbers(List<Integer> initialSet) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < initialSet.size(); i++) {
                result.addAll(steppingNumbers(initialSet.get(i)));
            }
            return result;
        }

        List<Integer> steppingNumbers(int n) {
            List<Integer> nums = new ArrayList<>();
            int lsd = n % 10;
            int num;
            if(lsd - 1 >= 0) {
                num = n * 10 + lsd - 1;
                    nums.add(num);
            }
            if(lsd + 1 < 10) {
                num = n * 10 + lsd + 1;
                    nums.add(num);
            }
            return nums;
        }

}
