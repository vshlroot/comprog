
package leetcode;

/**
 * Created by vishalss on 1/18/2016.
 */
/*
 Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class LeetCode79 {
    int[][] visited;

    // Following program can be made more concise in terms of the number of lines.
    // If we do that it will reduce the readability.
    // Generally such concise code will also frustrate the debugger.

    public boolean exist(char[][] board, String word) {
        // run it on every cell on board


        visited=new int[board.length][board[0].length];

        boolean result=false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //System.out.println("Starting from = "+board[i][j]);
                result=doesExist(board, word, 0, i, j);
                //System.out.println("    Received = "+result);
                if (result){
                    return result;
                }
            }
        }
        return false;
    }



    // word= word to be searched
    // index= index of character in the word
    // i,j= board index being considered.
    public boolean doesExist(char[][] board,String word,int index,int i,int j){
        //System.out.println("        index received is= "+index);
        //System.out.println("        i , j="+i+" , "+j);
        //System.out.println("        Current character of array= "+board[i][j]);
        //System.out.println("        Current character of WORD= "+word.charAt(index));
        if( board[i][j]!=word.charAt(index)) {
            //System.out.println("Board does not match character");
            return false;
        }
        if(index>=word.length()-1)
            return true;
        if(visited[i][j]==1){
            //System.out.println("    resturning from starting point only= "+visited[i][j]);
            return false;
        }

        //visited[i][j]=1;
        //printVisited();

        boolean result=false;
        if(visited[max(i-1,0)][j]!=1 && board[max(i-1,0)][j]==word.charAt(index+1)){
            //System.out.println("        Going in first");
            result=doesExist(board,word,index+1,max(i-1,0),j);
            //System.out.println("        First if returned= " + result);
        }
        if(result==false && visited[i][max(j-1,0)]!=1 && board[i][max(j-1,0)]==word.charAt(index+1)) {
            //System.out.println("        Going in second");
            result = doesExist(board, word, index + 1, i, max(j-1,0));
            //System.out.println("        second if returned= " + result);
        }
        if(result==false && visited[min(i + 1, board.length-1)][j]!=1 && board[min(i + 1, board.length-1)][j]==word.charAt(index+1)){
            //System.out.println("        Going in third");
            result=doesExist(board,word,index+1,min(i + 1, board.length-1),j);
            //System.out.println("        third if returned= " + result);
        }
        if(result==false && visited[i][min(j+1,board[0].length-1)]!=1 && board[i][min(j+1,board[0].length-1)]==word.charAt(index+1)){
            //System.out.println("        Going in fourth");
            result=doesExist(board,word,index+1,i,min(j+1,board[0].length-1));
            //System.out.println("        fourth if returned= " + result);
        }
        visited[i][j]=0;
        //System.out.println("        Finally " + result);
        return result;
    }

    public int max(int a, int b){
        return a>=b?a:b;
    }

    public int min(int a, int b){
        return a<=b?a:b;
    }

    public void printVisited(){
        System.out.println("=====");
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }
        System.out.println("=====");
    }
    public static void main(String[] args) {
        //char [][] in={{'A','A'},{'D','C'}};

        char [][] in={{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','b'},};
        String word="baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";


        /*
        // ABCE SFCS ADEE

        char[][] in={{'A','B','C','E'},
                     {'S','F','C','S'},
                     {'A','D','E','E'}};
        String word="BCCFB";
*/
        LeetCode79 ob=new LeetCode79();
        System.out.println(ob.exist(in,word));


        //System.out.println(in[0][0]==word.charAt(0));
    }
}
