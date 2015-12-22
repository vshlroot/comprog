package leetcode;

/**
 * Created by vishalss on 12/22/2015.
 */

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        //
        if(nums.length==0){
            return -1;
        }

        int result=0;
        int count=1;
        for (int i=1;i<nums.length;i++){
            if(nums[i]==nums[result]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                result=i+1;
                //i++;
            }
        }
        count=0;
        if(result>=nums.length){
            result=nums.length-1;
        }
        System.out.println("result= "+result);
        for (int i=0;result< nums.length && i<nums.length;i++){
            if(nums[i]==nums[result]){
                count++;
            }
        }
//        System.out.println(nums[result]+" , "+ count );
        if(count>nums.length/2){
            return nums[result];
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) {
        int input[]={8,9,8,99,9};
        System.out.println(((new LeetCode169()).majorityElement(input)));
    }
}
