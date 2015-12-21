package leetcode;

/**
 * Created by vishalss on 12/21/2015.
 */
/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        int carry=1;
        int sum=0;
        for(int i=digits.length-1;i>=0;i--){
            sum=digits[i]+carry;
            if(sum>9){
                digits[i]=sum%10;
                carry=1;
            }
            else{
                digits[i]=sum;
                carry=0;
            }
        }
        if(carry==1){
            int result[]=new int[digits.length+1];
            for(int i=0;i<digits.length;i++){
                result[i+1]=digits[i];
            }
            result[0]=1;
            return result;
        }
        return digits;
    }
}
