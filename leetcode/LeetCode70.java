package leetcode;

/**
 * Created by vishalss on 1/13/2016.
 */
/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class LeetCode70 {

    //  Basically it's fibonacci with a1=1and a2=2
    public int climbStairs(int n) {
        int i=3;
        int step1=1,step2=2;
        if(n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int result=0;
        while(i<=n){
            result=step1+step2;
            step1=step2;
            step2=result;
            i++;
        }
        return result;
    }

// Naive dumb idea to use recursion

    /*
    public int climbStairs(int n) {
        if(n<=0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        int result=0;
        int step1=climbStairs(n-1);
        int step2=climbStairs(n-2);
        if(step1>0){
            result+=step1;
        }
        if(step2>0){
            result+=step2;
        }
        return result;
    }
*/
    public static void main(String[] args) {
        LeetCode70 ob=new LeetCode70();
        int n=7;
        System.out.println(ob.climbStairs(n));
    }
}
