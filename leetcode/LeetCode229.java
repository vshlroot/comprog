package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vishalss on 1/2/2016.
 */
public class LeetCode229 {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> result=new ArrayList<>();
        int first=0,second=1;
        int fCount=0,sCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==first){
                fCount++;
            }
            else if(nums[i]==second){
                sCount++;
            }
            else if(fCount==0){
                first=nums[i];
                fCount++;
            }
            else if(sCount==0){
                second=nums[i];
                sCount++;
            }
            else{
                fCount--;
                sCount--;
            }
        }
        fCount=sCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==first){
                fCount++;
            }
            else if(nums[i]==second){
                sCount++;
            }
        }
        if(fCount>nums.length/3){
            result.add(first);
        }
        if(sCount>nums.length/3){
            result.add(second);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,3,3,1,9,1};
        LeetCode229 ob=new LeetCode229();
        Iterator it=(ob.majorityElement(nums)).iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
