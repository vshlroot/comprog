package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vishalss on 12/25/2015.
 */
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5].
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new ArrayList<Integer>();
        }
        int left=0; // including
        int top=0;  // including
        int right=matrix[0].length-1; // including
        int bottom=matrix.length-1; // including
        int count=(right+1)*(bottom+1);
        ArrayList<Integer> result=new ArrayList<>();
        int i=top,j=left;
        while(count>0){
            while(count>0 && j<=right){
                result.add(matrix[top][j]);
                //System.out.print(matrix[top][j] + ", ");
                j++;
                count--;
            }
            top++;
            i=top;
            System.out.println();
            while(count>0 && i<=bottom){
                result.add(matrix[i][right]);
                //System.out.print(matrix[i][right]+", ");
                i++;
                count--;
            }

            right--;
            j=right;
            while(count>0 && j>=left){
                result.add(matrix[bottom][j]);
                //System.out.print(matrix[bottom][j]+", ");
                j--;
                count--;
            }

            bottom--;
            i=bottom;
            while(count>0 && i>=top){
                result.add(matrix[i][left]);
                //System.out.print(matrix[i][left]+", ");
                i--;
                count--;
            }

            left++;
            j=left;
        }
        return result;
    }

    public static void main(String[] args) {

        //int input[][]={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        //int input[][]={{1,2,3,10},{4,5,6,11},{7,8,9,12}};
        /*
        [
 [ 1, 2, 3 ,10],
 [ 4, 5, 6 ,11],
 [ 7, 8, 9 ,12],
]
         */

        //int input[][]={{1,2,3},{4,5,6},{7,8,9}};
        /*
        [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ],
 [10, 11, 12]
]

         */

        int input[][]={{1,2}};
        List<Integer> result= (new LeetCode54()).spiralOrder(input);
        Iterator it=result.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+", ");
        }
    }
}
