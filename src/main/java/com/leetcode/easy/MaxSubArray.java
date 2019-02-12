package com.leetcode.easy;

/*
53. Maximum Subarray
Easy

3228

116

Favorite

Share
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaxSubArray {

    public static void main(String ...args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int [] a = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = maxSubArray.maxSubArray(a);
        System.out.println(sum);

    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum < 0 || nums[i] > sum) {
                sum = nums[i];
            }
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
