package com.interviewbit.string;

public class AddBinaryStrings {

    public static void main(String ...args) {
        AddBinaryStrings addBinaryStrings = new AddBinaryStrings();
        String addBinary = addBinaryStrings.addBinary("1010110111001101101000", "1000011011000000111100110");
        System.out.println(addBinary);
    }

    public String addBinary(String A, String B) {
        StringBuffer sb = new StringBuffer();
        int m = A.length();
        int n = B.length();
        char c = '0';
        char r;
        int i,j;
        for(i = m - 1, j = n - 1; i >= 0 && j >= 0; i--, j--) {
            char a = A.charAt(i);
            char b = B.charAt(j);

            if(a == '0' && b == '0') {
                if(c == '0') {
                    r = '0';
                    c = '0';
                } else {
                    r = '1';
                    c = '0';
                }
            } else if(a == '0' && b == '1') {
                if(c == '0') {
                    r = '1';
                    c = '0';
                } else {
                    r = '0';
                    c = '1';
                }
            } else if(a == '1' && b == '0') {
                if(c == '0') {
                    r = '1';
                    c = '0';
                } else {
                    r = '0';
                    c = '1';
                }
            } else {
                if(c == '0') {
                    r = '0';
                    c = '1';
                } else {
                    r = '1';
                    c = '1';
                }
            }
            sb.append(r);
        }
        if(m > n) {
            for( ; i >= 0; i--) {
                char a = A.charAt(i);
                if(a == '0') {
                    r = c;
                    c = '0';
                } else {
                    if(c == '0') {
                        r = a;
                        c = '0';
                    } else {
                        r = '0';
                        c = '1';
                    }
                }
                sb.append(r);
            }
        } else if(n > m) {
            for(; j >= 0; j--) {
                char a = B.charAt(j);
                if(a == '0') {
                    r = c;
                    c = '0';
                } else {
                    if(c == '0') {
                        r = a;
                        c = '0';
                    } else {
                        r = '0';
                        c = '1';
                    }
                }
                sb.append(r);
            }
        }
        if(c == '1') {
            sb.append(c);
        }

        return sb.reverse().toString();
    }
    }
