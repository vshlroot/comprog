package leetcode;

/**
 * Created by vishalss on 1/4/2016.
 */
/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
public class LeetCode153 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // already sorted array
        if(nums[0]<nums[1] && nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        if(nums[nums.length-1]<nums[nums.length-2] && nums[nums.length-1]<nums[0]){
            return nums[nums.length-1];
        }
        int start=0;
        int end=nums.length-1;
        int mid;
        while (start <= end) {
            mid=(start+end)/2;
            if(nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            // value lies on left side
            else if(nums[mid]<nums[nums.length-1]){
                end=mid-1;
            }
            // value lies on rightside
            else if(nums[mid]>nums[nums.length-1]){
                start=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={6};
        LeetCode153 ob=new LeetCode153();
        System.out.println(ob.findMin(nums));
    }
}
