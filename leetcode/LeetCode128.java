package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by vishalss on 1/16/2016.
 */
/*
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int longestStreak=0;
        int thisStreak=0;
        int leftStreak;
        int rightStreak;
        HashMap<Integer,Integer> h=new HashMap<>();
        for (int n:nums) {
            if(!h.containsKey(n)) {
                leftStreak=h.containsKey(n-1)?h.get(n-1):0;
                rightStreak=h.containsKey(n+1)?h.get(n+1):0;
                thisStreak=leftStreak+rightStreak+1;
                h.put(n,thisStreak);
                h.put(n-leftStreak,thisStreak);
                h.put(n+rightStreak,thisStreak);
                longestStreak=longestStreak>thisStreak?longestStreak:thisStreak;
            }
        }
        return longestStreak;
    }


}
