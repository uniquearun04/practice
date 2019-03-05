package com.interviewbit.stacksnQueues;

import java.util.Stack;

public class SimplifyPathV2 {


    public static void main(String ...args) {

//        String input = "/a/./b/../../c/";
//        String input = "/home/res/";
        String input = "/a/./b/../../c/";

        SimplifyPathV2 simplifyPath = new SimplifyPathV2();
        String path = simplifyPath.simplifyPath(input);
        System.out.println(path);

    }


    private static class Node {
        String val;
        Node next;
        public Node(String val) {
            this.val = val;
        }
    }

    public String simplifyPath(String A) {
        if(A.isEmpty() || A.equals("/")) return "/";
        String[] split = A.split("/");
        Stack<String> stack = new Stack<>();
        String curr;
        for (int i = 0; i < split.length; i++) {
            curr = split[i];
            if(curr.isEmpty() || curr.equals(".")) continue;;
            if(curr.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(curr);
        }

        StringBuilder path = new StringBuilder();
        for (String name : stack) {
            path.append("/");
            path.append(name);
        }
        if (path.length() == 0) path.append("/");
        return path.toString();
    }
}
