package com.interviewbit.math;

import java.util.Arrays;

public class RandomAttendence {

    public static void main(String ...args) {

        RandomAttendence randomAttendence = new RandomAttendence();
        int [] B = { 73114008, 106058146, 349169024, 424238336, 719885387, 41181723, 596516650, 385352037, 220912978, 546200643, 783368691, 298230675, 436318994, 358935157, 560891156, 736094042, 304089173, 499166352, 35005212, 521595369, 294702568, 118377660, 336465783, 56732146, 278722863, 233665124, 536595298, 468703136, 297224545, 193401033, 511344638, 635723059, 564843685, 321608783, 255672009, 480439687, 628175012, 47899273, 326886845, 44798604, 55195037, 305966150, 608413785, 756898538 };
        int[] solve = randomAttendence.solve(804289385, B);
        System.out.println(solve);
    }


    public int[] solve(int A, int[] B) {
        int ans [] = new int[B.length];
        String [] S = new String[A];
        for(int i = 1; i <= A; i++) {
            S[i -1] = ""+i;
        }
        Arrays.sort(S);

        for(int i = 0; i < B.length; i++) {
            ans[i] = Integer.parseInt(S[B[i] -1]);
        }

        return ans;
    }
}
