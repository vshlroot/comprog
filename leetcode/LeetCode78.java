package leetcode;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vishalss on 12/24/2015.
 */
/*
 Given a set of distinct integers, nums, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        // As it is required in the question to be sorted.
        Arrays.sort(nums);
        int num=0;
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int limit=(int)Math.pow(2,nums.length)-1;
        System.out.println("limit= "+limit);
        int bit;
        int i=0;
        List<Integer> current;
        while(limit>=0) {
            num=limit;
            current=new ArrayList<>();
            i=0;
            while(num>0){
                //System.out.println("num= "+num);
                if((num&1)==1){
                    System.out.print(nums[i]);
                    current.add(nums[i]);
                }
                num=num>>1;
                i++;
            }
            //System.out.println("");
            result.add(0,current);
            limit--;
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums={1,2,3,5};

        int[] nums={0};
        List<List<Integer>> result=(new LeetCode78()).subsets(nums);
        Iterator it=result.iterator();
        Iterator current;
        System.out.println("output=");
        while(it.hasNext()){
            System.out.print("=   = ");
            current=((List)it.next()).iterator();
            while(current.hasNext()){
                System.out.print(current.next() + ", ");
            }
            System.out.println("");
        }
        System.out.println("Result= "+result.size());
    }
}
