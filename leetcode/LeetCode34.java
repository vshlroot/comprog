package leetcode;

/**
 * Created by vishalss on 12/26/2015.
 */
/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        return searchRange1(nums, target, 0, nums.length - 1);
    }

    public int[] searchRange1(int[] nums, int target, int start, int end) {
        //int start=0;
        //int end=nums.length-1;
        int mid;
        int rightLimit=0;
        int leftLimit=end;
        int[] result={-1,-1};
        while(start<=end){
            mid=(start+end)/2;
            if(nums[mid]==target){
                leftLimit=rightLimit=mid;
                break;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        if(start>end){
            return result;
        }
        if(leftLimit>0 && nums[leftLimit-1]==target){ //range is extending towards the left
            start=0;
            end=leftLimit-1;
            while (start<=end){
                mid=(start+end)/2;
                if(nums[mid]==target){
                    leftLimit=mid;
                    end=leftLimit-1;
                }
                else if(nums[mid]<target){  // move towards right
                    start=mid+1;
                }
            }
        }
        //System.out.println("rightLimit= "+rightLimit);
        if(rightLimit<nums.length-1 && nums[rightLimit+1]==target){ //range is extending towards the right
            //System.out.printf("In right limit");
            start=rightLimit+1;
            end=nums.length-1;
            //System.out.println("start= "+start+"end= "+end);
            while (start<=end){
                //System.out.println("start= "+start+"end= "+end);
                mid=(start+end)/2;
                if(nums[mid]==target){
                    rightLimit=mid;
                    start=rightLimit+1;
                }
                else if(nums[mid]>target){  // move towards right
                    end=mid-1;
                }
            }
        }
        result[0]=leftLimit;
        result[1]=rightLimit;
        return result;
    }

    public static void main(String[] args) {
        int[] input={1,1,2,3,4,4,4,4,5,5};
        int[] result=(new LeetCode34()).searchRange(input,4);
        System.out.println("res="+result[0]);
        System.out.println("res="+result[1]);
    }
}
