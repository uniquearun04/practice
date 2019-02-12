package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String ...args) {

        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("()"));
        System.out.println(validParenthesis.isValid("[]"));
        System.out.println(validParenthesis.isValid("{}"));
        System.out.println(validParenthesis.isValid("(])"));
    }


    public boolean isValid(String s) {

        String SMALL_BRACKET_OPEN = "(";
        String SMALL_BRACKET_CLOSE = ")";
        String CURLY_BRACKET_OPEN = "{";
        String CURLY_BRACKET_CLOSE = "}";
        String LARGE_BRACKET_OPEN = "[";
        String LARGE_BRACKET_CLOSE = "]";
        List<String> openingBracketList = new ArrayList<>();
        openingBracketList.add(SMALL_BRACKET_OPEN);
        openingBracketList.add(CURLY_BRACKET_OPEN);
        openingBracketList.add(LARGE_BRACKET_OPEN);

        List<String> closingBracketList = new ArrayList<>();
        closingBracketList.add(SMALL_BRACKET_CLOSE);
        closingBracketList.add(CURLY_BRACKET_CLOSE);
        closingBracketList.add(LARGE_BRACKET_CLOSE);

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String bracket = s.substring(i,i+1);
            if(closingBracketList.contains(bracket)) {
                if(stack.isEmpty()) {
                    return false;
                }
                String peek = stack.peek();
                if((SMALL_BRACKET_CLOSE.equals(bracket) && SMALL_BRACKET_OPEN.equals(peek)) || (CURLY_BRACKET_CLOSE.equals(bracket) && CURLY_BRACKET_OPEN.equals(peek)) || (LARGE_BRACKET_CLOSE.equals(bracket) && LARGE_BRACKET_OPEN.equals(peek))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            if(openingBracketList.contains(bracket)) {
                stack.push(bracket);
            }
        }


        return stack.isEmpty();
    }
}
