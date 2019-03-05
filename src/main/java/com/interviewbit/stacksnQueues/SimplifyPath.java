package com.interviewbit.stacksnQueues;

import java.util.Stack;

public class SimplifyPath {


    public static void main(String ...args) {

//        String input = "/a/./b/../../c/";
//        String input = "/home/res/";
        String input = "/home//foo/";

        SimplifyPath simplifyPath = new SimplifyPath();
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
        if(A.length() <= 1) return A;
        String first = A.substring(0,1);
        String last = A.substring(A.length()-1, A.length());
        if(!first.equals("/")) {
            A = "/"+A;
        }
        if(!last.equals("/")) {
            A = A + "/";
        }
        Stack<String> stack = new Stack<>();
        String inputString = A;
        inputString = inputString.substring(1);
        int i = inputString.indexOf("/");
        String el;
        while(i >= 0) {
            el = inputString.substring(0,i);
            inputString = inputString.substring(i);
            if(el.equals("..")) {
                if(!stack.empty())stack.pop();
            } else if( el.equals(".")) {
                //do nothing
            } else if (el.equals("/")) {
                //do nothing
            } else if(el.equals("")) {
                //do nothing
            } else {
                stack.push(el);
            }
            i = inputString.indexOf("/");
//            int len = inputString.length();
//            if(i == 0 && len == 1) {
//                inputString = inputString.substring(1);
//            } else if(i > 0 && len > 1) {
//                inputString = inputString.substring(i+1);
//            }
            if(i >= 0) {
                inputString = inputString.substring(i+1);
            }
            i = inputString.indexOf("/");
            if(el.equals("") && i < 0) break;
        }
        Node head = null, tmp = null;
        if(stack.empty()) {
            return "/";
        }
        while(!stack.empty()) {
            el = stack.pop();
            tmp = new Node(el);
            if(head == null) {
                head = tmp;
            } else {
                tmp.next = head;
                head = tmp;
            }
        }
        Node curr = head;
        StringBuffer sb = new StringBuffer();
        while(curr != null) {
            sb.append("/").append(curr.val);
            curr = curr.next;
        }
        return sb.toString();

    }
}
