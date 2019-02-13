package com.interviewbit.array;

public class FlipBitsOfString {

    public int[] flip(String A) {
        int [] inputArray = new int[A.length()];
        int num = 0;
        for(int i = 0; i < A.length(); i++) {
            num = Integer.parseInt(A.substring(i,i+1));
            if(num == 1) {
                inputArray[i] = -1;
            }
        }

        int s = 0, e = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < inputArray.length; i++) {
            sum += inputArray[i];
            if(sum < 0) {
                sum = 0;
                s = i+1;
            }
            if(sum > max) {
                max = sum;
                e = i;
            }
        }

        int [] result = {s+1,e+1};
        return result;
    }

    public static void main(String ...args) {
        String in = "010";

        FlipBitsOfString flipBitsOfString = new FlipBitsOfString();
        int[] flip = flipBitsOfString.flip(in);
        System.out.println(flip);


    }
}
