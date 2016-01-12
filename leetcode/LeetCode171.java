package leetcode;

/**
 * Created by vishalss on 1/12/2016.
 */
/*
Related LeetCode168

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
 */
public class LeetCode171 {
    public int titleToNumber(String s) {
        int result=0,i=0;
        while(i<s.length()){
            result=result*26+(int)(s.charAt(i)-64);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode171 ob=new LeetCode171();
        String s="AA";
        System.out.println(ob.titleToNumber(s));
        //System.out.println((int)s.charAt(0));
    }

}
