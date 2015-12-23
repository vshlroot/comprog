/*
Test case show that if palindromes of same length are found then the one found first should be returned.

*/

public class LeetCode5{
    public String longestPalindrome(String s) {
		if(s==null || s.length()==0)
			return s;
		int len=s.length();
		int max_count=0,start=0,orientation=0,count_even,count_odd;
		//orientation=0=even 1=odd
		int i=0;
		for(i=0;i<len;i++){
			//odd length palindroms having i as their middle.
			count_odd=count_even=0;
			for(int j=1;i-j>-1 && i+j<len;j++){
				if(s.charAt(i-j)==s.charAt(i+j)){
					count_odd++;
				}
				else{
					break;
				}
			}
			//even length palindroms having i as their middle.
			for(int j=0;i-j>-1 && i+j+1<len;j++){
				if(s.charAt(i-j)==s.charAt(i+j+1)){
					count_even++;
				}
				else{
					break;
				}
			}
			if(count_even>max_count){
				if(count_even>=count_odd){
					max_count=count_even;
					start=i;
					orientation=0;
				}
			}
			else if(count_odd>=max_count){
				if(count_odd>=count_even){
					max_count=count_odd;
					start=i;
					orientation=1;
				}
			}
		}
		//even
		System.out.println("start="+start);
		System.out.println("max_count="+max_count);
		System.out.println("orientation="+orientation);
		
		String result="";
		if(orientation==0){
			result=s.substring(start-max_count+1,start+max_count+1);
		}
		else if(orientation==1){
			result=s.substring(start-max_count,start+max_count+1);
		}
		return result;
    }
}
