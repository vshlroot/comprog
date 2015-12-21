package leetcode;

import sort.Sort;

/**
 * Created by vishalss on 12/21/2015.
 */

/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class LeetCode189 {
    public void rotate(int[] nums, int k) {
        // there can be multiple rotation cycles. Taking mod of k with length of array
        k=k%nums.length;
        if(k<0)
            k+=nums.length;
        if(k==0 || k==nums.length){
            return;
        }
        int[] temp=new int[k];
        int i=0;
        // copy data in temp array
        for(i=0;i<k;i++){
            temp[i]=nums[nums.length-k+i];
        }
        //shift data
        int j=nums.length-1;
        for(i=nums.length-k-1;i>=0;i--){
            nums[j]=nums[i];
            j--;
        }
        // copy from temp
        for(i=0;i<k;i++){
            nums[i]=temp[i];
        }
    }

    public static void main(String[] args) {
        // int nums[]={-1};
        // (new LeetCode189()).rotate(nums, 2);

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        (new LeetCode189()).rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(nums[i]+", ");
        }
    }
}
