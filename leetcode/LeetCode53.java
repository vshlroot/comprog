package leetcode;

/**
 * Created by vishalss on 1/2/2016.
 */
/*
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
            return Integer.MIN_VALUE;
        int[] temp=new int[nums.length];
        int max;
        temp[0]=max=nums[0];
        for(int i=1;i<nums.length;i++){
            // if sum tuill last element is less than 0 then don't add it to the new sum as it will only lower it down.
            if(temp[i-1]<0){
                temp[i]=nums[i];
            }
            else
            {
                temp[i]=temp[i-1]+nums[i];;
            }
            if(temp[i]>max){
                max=temp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //int nums[]={−2,1,−3,4,−1,2,1,−5,4};
        int nums[]={-2,1,-3,4,-1,2,1,-5,-4};
        //int nums[]={-2,1};
        LeetCode53 ob=new LeetCode53();
        System.out.println(ob.maxSubArray(nums));
    }
}
