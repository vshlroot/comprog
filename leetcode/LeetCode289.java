package leetcode;

/**
 * Created by vishalss on 1/3/2016.
 */
/*
 According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state.

Follow up:

    Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

 */
public class LeetCode289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int i, j;
        int alive;
        // setting the states
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                alive = shallLive(board, m, n, i, j);
                if (alive == 1 && board[i][j]==0){
                    board[i][j]=2;
                }
                else if (alive == 1 && board[i][j]==1){
                    board[i][j]=3;
                }
                else if (alive == 0 && board[i][j]==0){
                    board[i][j]=0;
                }
                // no need of else as default is already 1
                else{
                    board[i][j]=1;
                }
            }

        }
        // flipping to new state.
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                board[i][j]=board[i][j]>>1;
            }
        }
    }

    public int shallLive(int[][] board,int m, int n, int k,int l){
        int count=0;
        System.out.println("k= "+k+"   l= "+l);
        int i,j;
        for (i = Integer.max(k-1,0); i <= Integer.min(k+1,m-1); i++) {
            for (j = Integer.max(l-1,0); j<=Integer.min(l+1,n-1); j++) {
                count+=board[i][j]&1;
            }
        }
        System.out.println(count);
        count-=board[k][l]&1;
        System.out.println(count);
        if((board[k][l]==1 && count==2) || count==3){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] grid={{1,0,1},{0,1,1}};
        LeetCode289 ob=new LeetCode289();

        ob.gameOfLife(grid);

        int i,j;
        int m=grid.length;
        int n=grid[0].length;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(grid[i][j] + ", ");
            }
            System.out.println();
        }

    }
}
