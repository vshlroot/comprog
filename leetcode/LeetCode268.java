package leetcode;

/**
 * Created by vishalss on 12/28/2015.
 */
/*
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class LeetCode268 {

    // uses xor operator to find the missing value.
    // the vlaues are in range 0 to n, that means if we xor all array values with [0,n] then it will return the missing value.
    public int missingNumber(int[] nums) {
        int result=nums.length;
        for(int i=0;i<nums.length;i++){
            result=result^i;
            result=result^nums[i];
        }
        return result;
    }
/*
    // uses sum method to find the missing number
    // can cause integerOverflow error.
    public int missingNumber(int[] nums) {
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        long shouldBeSum=(nums.length*(nums.length+1))/2;
        return (int)(shouldBeSum-sum);
    }
    */
}
