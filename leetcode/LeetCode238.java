package leetcode;

/**
 * Created by vishalss on 12/28/2015.
 */
/*
 Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class LeetCode238 {

    // LOGIC
    // is to do a forward pass and then a backward pass of multiplications.
    // use result as temp storage.
    public int[] productExceptSelf(int[] nums) {
        int result[]=new int[nums.length];
        int i;
        int n=nums.length;
        int mul=1;
        result[0]=mul*nums[0];
        // forward pass
        for (i=0;i<n;i++){
            result[i]=mul;
            mul*=nums[i];
        }
        // backward pass
        mul=1;
        for (i=n-1;i>=0;i--){
            result[i]=mul*result[i];
            mul*=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums={1,2,3,4};
        int[] nums={0,1,2,3};
        LeetCode238 obj1=new LeetCode238();
        int[] result=obj1.productExceptSelf(nums);
        for (int i=0;i<result.length;i++) {
            System.out.print(result[i]+", ");
        }
    }
}
