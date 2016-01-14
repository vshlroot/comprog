package leetcode;

/**
 * Created by vishalss on 1/12/2016.
 */
/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class LeetCode191 {
    public int hammingWeight(int n) {
    // will look into better solution than this hack.
    // For now be content with  this.
        return Integer.bitCount(n);

        /*
        int result=0;
        int mask;
        long n1=n;
        while(n1>0){
            System.out.println(Integer.toString(n,2));
            result+=n1&1;
            n1>>>=1;
        }
        return result;
        */
    }

    public static void main(String[] args) {
        LeetCode191 ob=new LeetCode191();
     //   int n=  2147483648;
        //System.out.println(ob.hammingWeight(n));
        System.out.println(ob.hammingWeight(Integer.parseUnsignedInt("2147483648")));
    }
}
