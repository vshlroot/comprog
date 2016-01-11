package leetcode;

/**
 * Created by vishalss on 1/11/2016.
 */
/*
 Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
 */
public class LeetCode326 {
    public boolean isPowerOfThree(int n) {
        if(n<=0)
            return false;
        // we need to log10 as natural log gives error in case of 243, some floating point round offs messing around.
        // Refer to
        // https://leetcode.com/discuss/78532/summary-all-solutions-new-method-included-at-15-30pm-jan-8th
        int log3=(int)(Math.log10(n)/Math.log10(3));
        return Math.pow(3,log3)==n?true:false;
    }

    public static void main(String[] args) {
        LeetCode326 ob=new LeetCode326();
        System.out.println(ob.isPowerOfThree(243));
        System.out.println(ob.isPowerOfThree(0));
    }
}
