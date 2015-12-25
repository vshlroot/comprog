package leetcode;

import sort.Sort;

/**
 * Created by vishalss on 12/25/2015.
 */
public class LeetCode75 {
    public void sortColors(int[] nums) {
        int two=nums.length-1;
        int zero=0; //where 0 will come next
        int temp;
        //till zero is 0
        //from zero to < two is 1
        // from [two to end is 2
        for(int i=0;i<=two;i++){
            if(nums[i]==0){
                temp=nums[zero];
                nums[zero]=0;
                nums[i]=temp;
                zero++;
            }
            else if(nums[i]==2){
                temp=nums[two];
                nums[two]=2;
                nums[i]=temp;
                two--;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={0,0};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+", ");
        }
        System.out.println();
        (new LeetCode75()).sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+", ");
        }
    }
}
