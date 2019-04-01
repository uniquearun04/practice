package com.interviewbit.rakuten;

/**
 * Created by achaudhary on 4/1/19.
 */
public class Test {

    public static void main(String ...args) {
        Test test = new Test();
        int A [] = {1, 3, 6, 4, 1, 2};
        int B [] = {1, 2, 3};

        int solution = test.solution(B);
        System.out.println(solution);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int [] B = new int[A.length+1];
        int j = 0;
        int num = 0;
        for(int i = 0; i < A.length; i++) {
            num = A[i];
            if(num > 0) {
                B[num-1] = num;
            }
        }
        for(int i = 0; i < B.length; i++) {
            if((i +1)!= B[i]){
                num = i+1;
                break;
            }
        }
        return num;
    }
}
