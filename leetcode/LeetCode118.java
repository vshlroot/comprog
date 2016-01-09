package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishalss on 1/9/2016.
 */
/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */
public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        if(numRows<=0){
            return new ArrayList<>();
        }
        int rows=1;
        int j;
        ArrayList<Integer> temp;
        List result=new ArrayList<>();
        temp=new ArrayList<>();
        temp.add(1);
        result.add(temp);
        int sum;
        while (rows<numRows){
            temp=new ArrayList<>();
            //System.out.println("rows= "+rows);
            for(j=0;j<=rows;j++){
                sum=0;
                sum+= j==0?0:(int)((ArrayList)result.get(rows-1)).get(j-1);
                sum+= j==rows?0:(int)((ArrayList)result.get(rows-1)).get(j);
                //System.out.println("    sum= "+sum);
                temp.add(sum);
            }
            result.add(temp);
            //System.out.println("Done with row="+rows);
            rows++;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode118 ob=new LeetCode118();
        List<List<Integer>> result=ob.generate(5);

    }
}
