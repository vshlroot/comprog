package leetcode;

/**
 * Created by vishalss on 1/12/2016.
 */
/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
 */
public class LeetCode168 {
    public String convertToTitle(int n) {
        int val;
        String result="";
        while (n>0){
            val=n%26==0?26:n%26;
            //val=n%26;
            //System.out.println(val);
            result=(char)(val+64)+result;
            if(n%26==0)
                n--;
            n=n/26;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode168 ob=new LeetCode168();
        int n;
        for (n = 0; n < 55; n++) {
            System.out.println(ob.convertToTitle(n));
        }

    }
}
