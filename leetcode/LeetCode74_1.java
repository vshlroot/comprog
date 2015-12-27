package leetcode;

/**
 * Created by vishalss on 12/27/2015.
 */
public class LeetCode74_1 {
    public boolean searchMatrix(int[][] matrix, int target){
        int start=0;
        int end=matrix.length-1;
        int mid;
        int row=0;

        while(start<=end) {
            mid=(start+end)/2;
            if(matrix[mid][0]==target){
                return true;
            }
            else if(matrix[mid][0]<target) {
                if (mid<matrix.length-1) {
                    if(matrix[mid+1][0]>target){    // it's current row
                        row=mid;
                        break;
                    }
                    else{   // binary search once again
                        start=mid+1;
                    }
                } else { // it's last row
                    row=mid;
                    break;
                }
            }
            else{ // target lies in upper side.
                if (mid>0) {
                    end=mid-1;
                    /*
                    if(matrix[mid-1][0]<target){    // it's current row
                        row=mid;
                        break;
                    }
                    else{   // binary search once again
                        end=mid-1;
                    }
                    */
                } else { // it's last row
                    row=mid;
                    break;
                }
            }
        }
        System.out.println("row= "+row);

        start=0;
        end=matrix[row].length-1;
        while (start<=end){
            mid=(start+end)/2;
            if(matrix[row][mid]==target){
                return true;
            }
            else if(matrix[row][mid]<target) { // target lies on right
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[][] input = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int[][] input = {{0}};
        LeetCode74_1 obj1 = new LeetCode74_1();
        System.out.println(obj1.searchMatrix(input, 1));
    }
}
