package leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * Created by vishalss on 12/23/2015.
 */
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List current;
        // O(n) space complexity for storing intermediate results.
        int[] result=new int[triangle.size()];
        int i,j;
        // copy the last row of the list into the result array.
        // for now these are the lowest values.
        for(i=0;i<triangle.size();i++){
            current=triangle.get(triangle.size()-1); //Fetch the last row;
            result[i]=(int)current.get(i);
        }
        // for each row in the list: bottom up fashion.
        for(i=triangle.size()-2;i>=0;i--){
            //current holds the current row of the list being processed.
            current=triangle.get(i);
            // for each element in the row process it.
            for(j=0;j<current.size();j++){
                // check which one of the two adjacent nodes is smaller and add it to the jth value of row.
                // save it in the result array,
                if(result[j]<=result[j+1]){
                    result[j]=result[j]+(int)current.get(j);
                }
                else{
                    result[j]=result[j+1]+(int)current.get(j);
                }
            }
        }
        //return first element of the result;
        return result[0];
    }
}
