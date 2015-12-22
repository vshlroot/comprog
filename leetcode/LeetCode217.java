package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vishalss on 12/22/2015.
 */
/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.
 */
public class LeetCode217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length==0){
            return false;
        }
        //HashMap<Integer,Integer> h=new HashMap<>();
        Set<Integer> h=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!h.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
