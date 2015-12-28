package leetcode;

/**
 * Created by vishalss on 12/28/2015.
 */
/*
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i,j,min;
        min=n-1;
        int temp;
        int flag=0;
        for(i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                break;
            }
        }
        //utils.Utils.printIntArray(nums,1,"");
        for(j=n-1;j>i && i>0;j--){
            if(nums[j]>nums[i-1]){
                break;
            }
        }
        System.out.println("i,j ="+(i-1)+", "+j);
        if(i>0) {
            temp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = temp;
        }
        //utils.Utils.printIntArray(nums,1,"");
        //sort the rest of the array[i to n-1]
        // we just have to reverse it...
        j=n-1;
        for(int k=i;k<((n-i)/2+i);k++){
            temp=nums[k];
            nums[k]=nums[j];
            nums[j]=temp;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] in={5,4,7,5,3,2};
        utils.Utils.printIntArray(in,1,"");
        LeetCode31 obj=new LeetCode31();
        obj.nextPermutation(in);
        utils.Utils.printIntArray(in,1,"");
    }
    // 5,5,2,3,4,7
}
