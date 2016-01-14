package leetcode;

/**
 * Created by vishalss on 1/14/2016.
 */
/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */

    /*
    Roman Number Symbols:
I 	1
V 	5
X 	10
L 	50
C 	100
D 	500
M 	1,000
     */

    // Make sure the CD is 900
    // DC is 1100
    // if smaller comes first then it must be subtracted.
    
public class LeetCode13 {
    public int romanToInt(String s) {
        int i=0;
        int result=0;
        int pVal=0;
        int curVal=0;
        while (i<s.length()){
            curVal=getValueOfSymbol(s.charAt(i));
            if(pVal<curVal){
                result+=curVal-pVal-pVal;
            }
            else {
                result+=curVal;
            }
            pVal=curVal;
            i++;
        }
        return result;

    }

    public int getValueOfSymbol(char ch){
        switch (ch){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode13 ob=new LeetCode13();
        String in="MCMXCVI";
        System.out.println(in);
        System.out.println(ob.romanToInt(in));
    }
}
