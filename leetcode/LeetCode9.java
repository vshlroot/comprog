/*
Big catch is the boundary conditions.
We need a long to check > MAXINT
otherwise it will fail for 1534236469


1465775641

*/

public class LeetCode9{
    public boolean isPalindrome(int x) {
		//long is required because we have to match a number > MAXINT that means the value to be matched with long must be in long as in in itself can not hold the value.
        long x1=x;
		int lastDigit=0,firstDigit=0;
        if(x<0){
            return false;
        }
		int numDig=(int)Math.log10((double)x)+1;
		System.out.println("numDig= "+numDig);		
		int divider=(int)Math.pow(10,numDig-1);
        while(x>0){
			System.out.println("x= "+x);
            lastDigit=x%10;
			System.out.println("Dividing by = "+divider);
			
			firstDigit=(int)(x/divider);
			System.out.println("lastDigit= "+lastDigit);
			System.out.println("firstDigit= "+firstDigit);
			if(lastDigit!=firstDigit)
				return false;
			x=x/10;
			System.out.println("x1 = "+x);
			x-=firstDigit*(divider/10);
			divider/=100;
        }
			return true;        
    }
}
