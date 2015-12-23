/*
Xor all numbers and you will get the result.
a^a=0;

0 0 = 0
0 1 = 1
1 0 = 1
1 1 = 0
*/

public class LeetCode136{
    public int singleNumber(int[] nums) {
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum^=nums[i];
        }
        return sum;
    }
}
