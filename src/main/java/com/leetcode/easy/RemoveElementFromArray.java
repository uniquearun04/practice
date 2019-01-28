package com.leetcode.easy;

public class RemoveElementFromArray {

    public static void main(String ...args) {

    }

    public int removeElement(int[] nums, int val) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                nums[i] = Integer.MIN_VALUE;
            } else {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
