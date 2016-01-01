package leetcode;

/**
 * Created by vishalss on 1/1/2016.
 */
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        if(grid==null){
            return 0;
        }
        int[][] a=new int[grid.length][grid[0].length];
        int i,j;
        // setting rows
        a[0][0]=grid[0][0];
        for(i=1;i<a.length;i++){
            a[i][0]=grid[i][0]+a[i-1][0];
        }
        // setting collumn
        for(i=1;i<a[0].length;i++){
            a[0][i]=grid[0][i]+a[0][i-1];
        }

        for(i=1;i<a.length;i++){
            for(j=1;j<a[0].length;j++){
                if(a[i-1][j]<=a[i][j-1]){
                    a[i][j]=a[i-1][j];
                }
                else{
                    a[i][j]=a[i][j-1];
                }
                a[i][j]+=grid[i][j];
            }
        }
        return a[a.length-1][a[0].length-1];
    }

    public static void main(String[] args) {
        int grid[][]={{1,2},{1,1}};
        LeetCode64 ob=new LeetCode64();
        System.out.println(ob.minPathSum(grid));
    }
}
