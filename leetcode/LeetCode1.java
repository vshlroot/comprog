public class LeetCode1{
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
		int len=nums.length;
		int nums_original[]=new int[len];
		for(int i=0;i<len;i++)
			nums_original[i]=nums[i];
		if(len<=2){
			if(len%2==0 && (nums[0]+nums[1])==target){
				result[0]=1;
				result[1]=2;
			}
			else{
				result[0]=0;
				result[1]=0;
			}
		}
		else{
			Arrays.sort(nums);
			//Binary Search to figire out the length till which to searcj.
			//All nums >= target must not be searched.
			/*int start=0,end=len;
			
			while(true)
			{
				mid=(start+len)/2;
				if(nums[mid]==target)
					limit=target-1;
				else if(nums[mid]>target){
					end=target-1;
				}
				else if(nums[mid]<target){
					end=target-1;
				}
			}
			*/
			int i=0,j=len-1;
			int flag=0,sum=0;
			while(i<j && flag==0)
			{
				sum=nums[i]+nums[j];
				if(sum==target){
					flag=1;
					break;
				}
				else if(sum<target){
					i++;
				}
				else if(sum>target){
					j--;
				}
			}
			if(flag==0)
			{
				result[0]=0;
				result[1]=0;
			}
			else{
//				int index1
				/*
				for(int m=0;m<len;m++){
					if(nums_original[m]==nums[i]){
						result[0]=m+1;
						break;
					}
				}
				
				for(int m=0;m<len;m++){
					if(nums_original[m]==nums[j]){
						result[1]=m+1;
						break;
					}
				}
				*/
				//System.out.println("nums[i]="+nums[i]);
				//System.out.println("nums[j]="+nums[j]);
				int flag_1=0;
				for(int m=0;m<len;m++){
					if(nums_original[m]==nums[i]){
						result[0]=m+1;
						flag_1=1;
						break;
					}
					else if(nums_original[m]==nums[j]){
						result[0]=m+1;
						flag_1=2;
						break;
					}
				}
				if(flag_1==1){
					for(int m=len-1;m>=0;m--){
						if(nums_original[m]==nums[j]){
							result[1]=m+1;
							break;
						}
					}
				}
				else if(flag_1==2){
					for(int m=len-1;m>=0;m--){
						if(nums_original[m]==nums[i]){
							result[1]=m+1;
							break;
						}
					}
				}
				//NOT REQUIRED
				/*if(result[0]>result[1])
				{
					int temp=result[0];
					result[0]=result[1];
					result[1]=temp;
				}
				*/
			}
		}		
		return result;
    }
}
