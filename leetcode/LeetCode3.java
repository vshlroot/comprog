public class LeetCode3{
    public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()==0)
			return 0;
		HashMap h=new HashMap();
		int len=s.length();
		int i=0,max_count=0,count=0;
		for(i=0;i<len;i++){
			h.clear();
			count=0;
			while(i<len && !h.containsKey(s.charAt(i))){
				h.put(s.charAt(i),i);
				count++;
				i++;
			}
			if(i<len)
				i=(int)h.get(s.charAt(i));
			if(count>max_count){
				max_count=count;
			}
		}
		return max_count;
    }
}

/*
aaaa
aaab
aaabc
dvdf
*/
