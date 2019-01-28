package com.interviewbit.math;

public class GridUniquePaths {

    public static void main(String ...args) {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
//        gridUniquePaths.uniquePaths(2,2);
        System.out.println(gridUniquePaths.uniquePaths(2,2));
        System.out.println(gridUniquePaths.uniquePaths(3,3));
        System.out.println(gridUniquePaths.uniquePaths(4,4));
        System.out.println(gridUniquePaths.uniquePaths(5,5));
        System.out.println(gridUniquePaths.uniquePaths(2,3));
        System.out.println(gridUniquePaths.uniquePaths(2,4));
        System.out.println(gridUniquePaths.uniquePaths(2,5));
        System.out.println(gridUniquePaths.uniquePaths(2,6));
        System.out.println(gridUniquePaths.uniquePaths(2,7));
        System.out.println(gridUniquePaths.uniquePaths(2,8));
        System.out.println(gridUniquePaths.uniquePaths(2,9));
        System.out.println(gridUniquePaths.uniquePaths(2,10));
    }

    public int uniquePaths(int a, int b) {
          /* If either 1 row or 1 column are there then the only way to end
             is to traverse through that row or column respectively.*/
        if(a==1 || b==1)
            return 1;
          /*If there are more than one row and column then u need to move
            either right or down reducing one row or one column respectively
            and adding that way in answer*/
        else{
            int ans = 0;
            ans = uniquePaths(a-1,b)+uniquePaths(a,b-1);
            return ans;
        }
    }
}
