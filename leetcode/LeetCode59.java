package leetcode;

import java.util.ArrayList;

/**
 * Created by vishalss on 12/25/2015.
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        if(n==0){
            return new int[0][0];
        }
        int[][] matrix=new int[n][n];
        int left=0; // including
        int top=0;  // including
        int right=matrix[0].length-1; // including
        int bottom=matrix.length-1; // including
        int count=1;
        int i=top,j=left;
        int limit=n*n+1;
        while(count<limit){
            while(count<limit && j<=right){
                matrix[top][j]=count;
                //System.out.print(matrix[top][j] + ", ");
                j++;
                count++;
            }
            top++;
            i=top;
            System.out.println();
            while(count<limit && i<=bottom){
                matrix[i][right]=count;
                //System.out.print(matrix[i][right]+", ");
                i++;
                count++;
            }

            right--;
            j=right;
            while(count<limit && j>=left){
                matrix[bottom][j]=count;
                //System.out.print(matrix[bottom][j]+", ");
                j--;
                count++;
            }

            bottom--;
            i=bottom;
            while(count<limit && i>=top){
                matrix[i][left]=count;
                //System.out.print(matrix[i][left]+", ");
                i--;
                count++;
            }

            left++;
            j=left;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n=3,i,j;
        int[][] result=(new LeetCode59()).generateMatrix(n);
        for (i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(result[i][j]+" ,");
            }
            System.out.println("");
        }
    }


}
