package leetcode;

/**
 * Created by vishalss on 12/26/2015.
 */
/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become

 4 5 6 7 0 1 2
 0 1 2 3 4 5 6

4 5 6 7 === 0 1 2 4 5 6 7 === 0 1 2
0 1 2 3     4 5 6 0 1 2 3     4 5 6
            0 1 2 3 4 5 6


You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid=0;

        while(start<=end) {
            //System.out.println(start+"end= "+end);
            mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid]<nums[end]){
                end=mid;
            }
            else {
                start=mid+1;
            }
        }
        int smallest=mid;
        //System.out.println("smallest= "+smallest);
        //System.out.println("Target= "+target+"nums[nums.length-1]= "+nums[nums.length-1]);
        if(target<=nums[nums.length-1]){
            //System.out.println("In if");
            start=smallest;
            end=nums.length-1;
        }
        else{
            //System.out.println("In else");
            start=0;
            end=smallest-1;
        }

        // normal binary search continues
        while(start<=end){
            //System.out.println(start+"   end= "+end);
            mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                end=mid-1;

            }
            else{
                start=mid+1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] input={8,9,2,3,4};
        LeetCode33 obj1=new LeetCode33();
        //System.out.println("=== "+obj1.search(input, 9));
        for(int i=0;i<input.length;i++){
            System.out.println(input[i]+"=== "+obj1.search(input, input[i]));
        }

    }
}
