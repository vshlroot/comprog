package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vishalss on 12/22/2015.
 */
/*
Given an array of integers and an integer k, find out whether there are two distinct
indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length<=0){
            return false;
        }
        Set<Integer> h=new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if(i>k){
                h.remove(nums[i-k-1]);
            }
            if(!h.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
