package leetcode;

/**
 * Created by vishalss on 1/20/2016.
 */
/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]

Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]

Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LeetCode329 {

    // There can be no repetetion of elements as the sequence must be strictly increasing.
    // So we don't have to worry about loops. It will be handled implicitly.

    int[][] solution;
    int maxLength;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }
        solution=new int[matrix.length][matrix[0].length];
        maxLength=1; // default value

        // Calculating the value for each cell.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                    increasingSequence(matrix,i,j);
            }
        }
        return maxLength;
    }

    public int increasingSequence(int[][] matrix, int i, int j){

        // checking if already calculated, in case of already calculted value solution[i][j] will be > 0
        if(solution[i][j]>0) {
            return solution[i][j];
        }
        solution[i][j]=1;
        // for the four sides we can go to
        int one, two, three, four;
        one=two=three=four=0;
        if(matrix[max(i-1,0)][j]>matrix[i][j]) {
            one = increasingSequence(matrix, max(i - 1, 0), j);
        }
        if(matrix[min(i + 1, matrix.length - 1)][j]>matrix[i][j]) {
            two = increasingSequence(matrix, min(i + 1, matrix.length - 1), j);
        }
        if(matrix[i][max(j-1,0)]>matrix[i][j]) {
            three = increasingSequence(matrix, i, max(j - 1, 0));
        }
        if(matrix[i][min(j+1,matrix[0].length-1)]>matrix[i][j]) {
            four = increasingSequence(matrix, i, min(j + 1, matrix[0].length - 1));
        }
        // getting the max value among the four. Updating maxLength accordingly.
        solution[i][j]=max(one,two,three,four)+1;
        if(solution[i][j]>maxLength){
            maxLength=solution[i][j];
        }
        return solution[i][j];
    }

    // basic util functions
    public int max(int a, int b){
        return a>=b?a:b;
    }

    public int max(int a, int b, int c, int d){
        int temp1=c>=d?c:d;
        return a>=b?a>=temp1?a:temp1:b>=temp1?b:temp1;
    }

    public int min(int a, int b){
        return a<=b?a:b;
    }


    public static void main(String[] args) {
        LeetCode329 ob= new LeetCode329();

        //int[][] in={{9,9,4},{6,6,4},{2,1,1}};
        //int[][] in={{1,2},{4,3}};
        int[][] in={{13,4,5},{3,2,6},{2,2,1}};

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                System.out.print(in[i][j]+" , ");
            }
            System.out.println();
        }

        System.out.println(ob.longestIncreasingPath(in));

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                System.out.print(ob.solution[i][j]+" , ");
            }
            System.out.println();
        }

        //System.out.println(ob.max(1,2,3,4));
        //System.out.println(ob.max(1,4,2,3));

    }
}
