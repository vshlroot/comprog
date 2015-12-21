package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vishalss on 12/21/2015.
 */
/*
 Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */

public class LeetCode228 {
    public ArrayList<String> summaryRanges(int[] nums) {
        if(nums.length==0){
            return new ArrayList<String>();
        }
        int start=0, end=0;
        ArrayList<String> result=new ArrayList<>();
        int i=0;
        if(nums.length==1){
            result.add(nums[0]+"");
            return result;
        }


        for(i=0;i<nums.length-1;i++){
            start=nums[i];
            end=nums[i];
            while(i<nums.length-1 && nums[i]+1==nums[i+1]){
                end=nums[i+1];
                i++;
            }
            if(i==nums.length-1 && nums[i]==nums[i-1]){
                end=nums[i];
            }
            if(start!=end){
                result.add(start+"->"+end);
            }
            else{
                result.add(start+"");
            }
        }
        if(nums[nums.length-1]>nums[nums.length-2]+1){
            result.add(nums[nums.length-1]+"");
        }
        return result;
    }

}
