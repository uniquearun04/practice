package com.leetcode.easy;

public class SearchInsertPosition {


    public static void main(String ...args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

//        int [] a1 = {1,2,5,6};
//        int t1 = 5;
//        System.out.println(searchInsertPosition.searchInsert(a1, t1));
//        t1 = 2;
//        System.out.println(searchInsertPosition.searchInsert(a1, t1));
//        t1 = 7;
//        System.out.println(searchInsertPosition.searchInsert(a1, t1));
//        t1 = 0;
//        System.out.println(searchInsertPosition.searchInsert(a1, t1));

        int [] a2 = {1,3};
        int t2 = 0;
        System.out.println(searchInsertPosition.searchInsert(a2, t2));
    }


    public int searchInsert(int[] nums, int target) {
        return binSearch(nums, 0, nums.length -1, target);
    }

    public int binSearch(int[] nums, int lo, int hi, int target) {
        if(hi < lo) {
            return lo;
        }
        if(lo == hi) {
            if(target == nums[hi]) {
                return hi;
            }
            if(target > nums[hi]) {
                return hi +1;
            }
            return lo;
        }
        int mid = (lo + hi) / 2;
        if(target == nums[mid]) {
            return mid;
        }
        if(target < nums[mid]) {
            return binSearch(nums, lo, mid -1, target);
        }
        return binSearch(nums, mid+1, hi, target);
    }
}
