package leetcode;

import java.util.*;

/**
 * Created by vishalss on 12/24/2015.
 */
/*
  Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


 */
public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // As it is required in the question to be sorted.
        Arrays.sort(nums);
        LinkedHashSet h=new LinkedHashSet();
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
            h.add(current);
            //result.add(0,current);
            limit--;
        }
        Iterator it=h.iterator();
        while (it.hasNext())
            result.add((ArrayList<Integer>)it.next());

        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,2,2};

        //int[] nums={0};
        List<List<Integer>> result=(new LeetCode90()).subsetsWithDup(nums);
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
