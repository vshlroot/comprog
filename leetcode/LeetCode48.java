package leetcode;

/**
 * Created by vishalss on 12/27/2015.
 */
/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
public class LeetCode48 {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }

    public void transpose(int[][] matrix){
        int i,j,temp;
        int n=matrix.length;
        for(i=0;i<n;i++){
            for(j=i+1;j<n;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    public void reverseRows(int[][] matrix){
        int n=matrix.length;
        int i,j;
        int temp;
        for(i=0;i<n;i++) {
            for (j = 0; j < n/2; j++) {
                temp=matrix[i][n-j-1];
                matrix[i][n-j-1]=matrix[i][j];
                matrix[i][j]=temp;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] input={{1,2,3},{4,5,6},{7,8,9}};
        int n=input.length;
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++) {
                System.out.print(input[i][j] + ", ");
            }
            System.out.println();
        }
        LeetCode48 obj1=new LeetCode48();
        obj1.rotate(input);
        for(i=0;i<n;i++) {
            for (j = 0; j < n; j++) {
                System.out.print(input[i][j] + ", ");
            }
            System.out.println();
        }

    }
}
