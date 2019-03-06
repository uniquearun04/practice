package com.interviewbit.stacksnQueues;

import com.interviewbit.math.TrailingZerosFactN;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TrapRainWater {

    public static void main(String ...args) {
        TrapRainWater trapRainWater = new TrapRainWater();
        int trap = trapRainWater.trap(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));
        System.out.println(true);
    }

    public int trap(final List<Integer> A) {

        Stack<Integer> stack = new Stack<>();

        int i, max = 0, sum = 0, currVal, pop;
        for(i = 1; i < A.size(); i++) {
            if(A.get(i) < A.get(i-1)) {
                max = A.get(i-1);
                stack.push(A.get(i-1));
                stack.push(A.get(i));
                i++;
                break;
            }
        }
        while(i < A.size()) {
            currVal = A.get(i);
            if(currVal <= max) {
                stack.push(currVal);
            } else {
                while(!stack.isEmpty()) {
                    pop = stack.pop();
                    sum += (max - pop);
                }
                max = currVal;
                stack.push(currVal);
            }
            i++;
        }

        if(!stack.isEmpty()) {
            max = stack.pop();
            while(!stack.isEmpty()) {
                pop = stack.pop();
                if(pop <= max) {
                    sum += (max - pop);
                } else {
                    max = pop;
                }
            }
        }
        return sum;
    }
}
