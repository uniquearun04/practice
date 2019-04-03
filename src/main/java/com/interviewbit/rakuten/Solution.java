package com.interviewbit.rakuten;

/**
 * Created by achaudhary on 4/1/19.
 */
public class Solution {

    public static void main(String ...args) {
        Solution test = new Solution();
        String solution = test.solution(1,4);
        System.out.println(solution);
    }


    public String solution(int a, int b) {
        StringBuilder sb = new StringBuilder();

        while(a >= 2 || b >= 2) {
            if(a > 0 && b > 0) {
                if(a == b) {
                    sb.append("aa");
                    a -= 2;
                    sb.append("bb");
                    b -= 2;
                } else if(a > b) {
                    sb.append("aa");
                    a -= 2;
                    sb.append("b");
                    b -= 1;
                } else {
                    sb.append("bb");
                    b -= 2;
                    sb.append("a");
                    a -= 1;
                }
            } else {
                break;
            }

        }
        while(a > 0) {
            sb.append("a");
            a--;
        }
        while(b > 0) {
            sb.append("b");
            b--;
        }

        return sb.toString();
    }
}
