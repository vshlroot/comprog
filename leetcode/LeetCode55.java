package leetcode;

/**
 * Created by vishalss on 1/2/2016.
 */
/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

HIGHLY AMBIGUOUS QUESTION:
It means can we cross or at least reach the last cell.
 Every cell represent how far you can go from current cell.
  It does not mean that if cell==2 then you have to jump 2 steps. It says you CAN (NOT MUST) jump.

  We call such questions idiotic questions without proper wording by the setter...No offense to the setter though.
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int i=0;
        // idea is to see if the current cell can be reached or not, if yes then we move on or we return false.
        int reachable=nums[0];
        for(i=1;i<nums.length;i++){
            if(reachable<i){
                return false;
            }
            if(reachable<i+nums[i]){
                reachable=i+nums[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={1,1,0,0};
        LeetCode55 ob=new LeetCode55();
        System.out.println(ob.canJump(nums));
    }
}
