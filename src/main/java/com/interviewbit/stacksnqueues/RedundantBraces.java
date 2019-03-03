package com.interviewbit.stacksnqueues;

import java.util.Stack;

/**
 * Created by achaudhary on 3/3/19.
 */
public class RedundantBraces {

    public static void main(String ...args) {
        String input = "((a+b))";
        RedundantBraces redundantBraces = new RedundantBraces();
        int braces = redundantBraces.braces(input);
        System.out.println(braces);
    }


    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        char c;
        char pop;
        int count = 0;
        for(int i = 0; i < A.length(); i++) {
            c = A.charAt(i);
            if(c == ' ') continue;
            if(c == ')') {
                count = 0;
                while(!stack.isEmpty()) {
                    pop = stack.pop();
                    if(pop == '(') {
                        if(count <= 0) return 1;
                        break;
                    }
                    count++;
                }
            } else {
                stack.push(c);
            }
        }
        return 0;
    }
}
