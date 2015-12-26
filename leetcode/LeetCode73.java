package leetcode;

/**
 * Created by vishalss on 12/26/2015.
 */
/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        if(m==1){
            for(int i=0;i<n;i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 0; j < n; j++) {
                        matrix[0][j] = 0;
                    }
                    return;
                }
            }
            return;
        }
        if(n==1){
            for(int i=0;i<m;i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 0; j < m; j++) {
                        matrix[j][0] = 0;
                    }
                    return;
                }
            }
            return;
        }

        int row1=1;
        // Going through first row column wise
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                row1=0;
                break;
            }
        }

        //check all the rows.
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                matrix[0][0]=0;
                break;
            }
        }

        int j,i;
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        // setting submatrix row wise
        for(i=1;i<m;i++){
            if(matrix[i][0]==0){
                for(j=1;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }
        // setting submatrix column wise
        for(i=1;i<n;i++){
            if(matrix[0][i]==0){
                for(j=1;j<m;j++){
                    matrix[j][i]=0;
                }
            }
        }
        // setting first row
        if(matrix[0][0]==0){
            for(i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
        // setting first column
        if(row1==0){
            for(i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] input={{1,1,1},{0,1,2}};
        (new LeetCode73()).setZeroes(input);
        int i,j;
        for(i=0;i<input.length;i++){
            for(j=0;j<input[0].length;j++){
                System.out.print(input[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}
