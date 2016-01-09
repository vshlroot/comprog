package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishalss on 1/9/2016.
 */
/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class LeetCode119 {

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result=new ArrayList<>();
        if(rowIndex<0){
            return result;
        }
        if(rowIndex>=0){
           result.add(1);
        }
        int j;
        long temp;
        long upper=rowIndex;
        for(j=1;j<=rowIndex;j++){
            // We need to check which one will grow faster?
            // In this case (upper)/j will grow slower than result.get(j-1)*(upper)
            temp=(int)(result.get(j-1))*(upper)/j;
            result.add((int)temp);
            upper--;
        }
        return result;
    }

}
