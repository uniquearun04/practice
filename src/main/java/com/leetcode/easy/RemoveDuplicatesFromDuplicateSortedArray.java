package com.leetcode.easy;

public class RemoveDuplicatesFromDuplicateSortedArray {



    public int removeDuplicates(int[] nums) {

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[j]) {
                nums[i] = Integer.MIN_VALUE;
            } else {
                j++;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }


}
