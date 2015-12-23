/*
Big catch is the boundary conditions.
We need a long to check > MAXINT
otherwise it will fail for 1534236469

*/

public class LeetCode7{
    public int reverse(int x) {
		//long is required because we have to match a number > MAXINT that means the value to be matched with long must be in long as in in itself can not hold the value.
        long x1=x;
        long y=0;
        int multiplier=1;
        if(x<0){
            multiplier=-1;
            x=x*multiplier;
        }
        while(x>0){
			System.out.println("x= "+x);
            y=y*10+x%10;
			if(y>Integer.MAX_VALUE||y<Integer.MIN_VALUE)
            return 0;
            x=x/10;
			System.out.println("y= "+y);
			System.out.println(" ");
        }
        return (int)(y*multiplier);
    }
}
