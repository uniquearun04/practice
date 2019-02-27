package com.interviewbit.string;

import java.util.ArrayList;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.

Example:

Given “25525511135”,

return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
 */
public class ValidIPAddress {

    public static void main(String ...args) {
        ValidIPAddress validIPAddress = new ValidIPAddress();
        ArrayList<String> list = validIPAddress.restoreIpAddresses("asdf");
        System.out.println(list);
    }

    public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> list = new ArrayList<>();
        int n = A.length();
        if(n >= 4 || n <= 12 ) {

        }
        return list;
    }
}
