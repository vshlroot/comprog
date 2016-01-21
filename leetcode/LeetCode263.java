package leetcode;

/**
 * Created by vishalss on 1/21/2016.
 */
/*
 Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
 */
public class LeetCode263 {
    // Idea is to reduce the number by consistently dividing it with 2 3 and 5.
    // If in the end anything other than 1 is left that means it is an ugly number.
    public boolean isUgly(int num) {
        if(num==0){
            return false;
        }
        try {
            while (num % 5 == 0) {
                num = num / 5;
            }
            while (num % 3 == 0) {
                num = num / 3;
            }
            while (num % 2 == 0) {
                num = num / 2;
            }
            System.out.println(num);
            if (num != 1) {
                return false;
            }
            return true;
        }
        catch (RuntimeException e){
            System.out.println("RuntimeException");
            return false;
        }
    }

    public static void main(String[] args) {
        LeetCode263 ob=new LeetCode263();
        System.out.println(ob.isUgly(8));
        System.out.println(ob.isUgly(9));
        System.out.println(ob.isUgly(14));

    }
}
