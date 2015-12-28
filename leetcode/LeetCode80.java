package leetcode;

/**
 * Created by vishalss on 12/28/2015.
 */
/*
 Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length. s
 */
public class LeetCode80 {
    public int removeDuplicates(int[] nums) {
        int i;
        int j;
        int n=nums.length;
        int limit=2;
        int counter=1;  //Two duplicates allowed

        for(i=1,j=1;i<n;i++){
            //System.out.println("i= "+i+"j= "+j);
            if(nums[i]==nums[i-1] && counter<limit){
                //System.out.println("in 1");
                nums[j]=nums[i];
                j++;
                counter++;
            }
            else if(nums[i]==nums[i-1] && counter==limit){
                //System.out.println("in 2");
                //counter=1;
            }
            else if(nums[i]!=nums[i-1]){
                //System.out.println("in 3");
                nums[j]=nums[i];
                j++;
                counter=1;
            }
        }
        return j++;
    }

    public static void main(String[] args) {
        int[] in={1,1,1,1,2,2,2,9};
        LeetCode80 obj1=new LeetCode80();
        int res=obj1.removeDuplicates(in);
        System.out.println(res);
        for(int i=0;i<res; i++) {
            System.out.print(in[i]+", ");
        }
    }

}
