package leetcode;

/**
 * Created by vishalss on 12/22/2015.
 */
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid.
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        if(m==0 && n==0){
            System.out.println(" m and n 0");
            return 0;
        }

        if( m==0 || n==0){
            System.out.println(" m OR n 0");
            return 1;
        }

        int a[][]=new int[m][n];
        int i;
        int j;
        for(i=0;i<m;i++){
            a[i][0]=1;
        }
        for(i=0;i<n;i++){
            a[0][i]=1;
        }
        //a[0][0]=0;
        for(i=1;i<m;i++){
            for (j=1;j<n;j++){
                a[i][j]=a[i-1][j]+a[i][j-1];
            }
        }
        //System.out.println("Returning= "+ a[m-1][n-1]);
        return a[m-1][n-1];
    }

    public static void main(String[] args) {
        int result=(new LeetCode62()).uniquePaths(1,2);
        System.out.println("result= "+result);
    }
}
