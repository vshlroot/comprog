package leetcode;

/**
 * Created by vishalss on 12/22/2015.
 */
/*
Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 */
public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
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
            if(obstacleGrid[i][0]==0){
                a[i][0]=1;
            }
            else{
                a[i][0]=0;
                break;
            }

        }
        for(i=0;i<n;i++){
            if(obstacleGrid[0][i]==0){
                a[0][i]=1;
            }
            else{
                a[0][i]=0;
                break;
            }
        }
        for(i=1;i<m;i++){
            for (j=1;j<n;j++){
                if(obstacleGrid[i][j]==0){
                    a[i][j]=a[i-1][j]+a[i][j-1];
                }
                else{
                    a[i][j]=0;
                }

            }
        }
        //System.out.println("Returning= "+ a[m-1][n-1]);
        return a[m-1][n-1];
    }
}
