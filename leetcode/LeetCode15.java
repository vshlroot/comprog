package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vishalss on 1/9/2016.
 */
/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
    The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
    (0,0,0)

 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList result=new ArrayList();
        ArrayList<Integer> temp;
        Arrays.sort(nums);
        //utils.Utils.printIntArray(nums,1,"");
        if(nums==null || nums.length<3){
            return result;
        }
        int n=nums.length;
        //utils.Utils.printIntArray(nums,1,"");
        int start,end,sum;
        int tempTarget;

        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            tempTarget=0-nums[i];
            start=i+1;
            end=n-1;
            while(start<end){
                sum=nums[start]+nums[end];
                if(sum==tempTarget){
                    temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    result.add(temp);
                    while(start+1 < end && nums[start]==nums[start+1]){
                        start++;
                    }
                    while(start+1 < end && nums[end]==nums[end-1]){
                        end--;
                    }
                }
                if(sum>tempTarget){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums={8,5,12,3,-2,-13,-8,-9,-8,10,-10,-10,-14,-5,-1,-8,-7,-12,4,4,10,-8,0,-3,4,11,-9,-2,-7,-2,3,-14,-12,1,-4,-6,3,3,0,2,-9,-2,7,-8,0,14,-1,8,-13,10,-11,4,-13,-4,-14,-1,-8,-7,12,-8,6,0,-15,2,8,-4,11,-4,-15,-12,5,-9,1,-2,-10,-14,-11,4,1,13,-1,-3,3,-7,9,-4,7,8,4,4,8,-12,12,8,5,5,12,-7,9,4,-12,-1,2,5,4,7,-2,8,-12,-15,-1,2,-11};
        int[] nums={0,0,0};
        //int[] nums={-1,0,1, 2, -1, -4};
        LeetCode15 ob=new LeetCode15();
        ob.threeSum(nums);
    }


}
