package leetcode;

/**
 * Created by vishalss on 1/4/2016.
 */
/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class LeetCode162 {
    public int findPeakElement(int[] nums){
        if(nums.length==1){
            return 0;
        }
        int i;
        int start,mid,end;
        start=0;
        end=nums.length-1;
        while(start<=end){
            mid=(start+end)/2;
            System.out.println("mid= "+mid);
            if(mid==0 && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid==0 && nums[mid]<nums[mid+1]){
                start=mid+1;
            }
            else if(mid==nums.length-1 && nums[mid]>nums[mid-1]){
                return mid;
            }
            else if(mid==nums.length-1 && nums[mid]<nums[mid-1]){
                end=mid-1;
            }
            else if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1]){
                start=mid+1;
            }
            else if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
                start=mid+1;
            }
            else if(nums[mid]<nums[mid-1] && nums[mid]>nums[mid+1]){
                end=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={9,8};
        LeetCode162 ob=new LeetCode162();
        System.out.println(ob.findPeakElement(nums));
    }
}
