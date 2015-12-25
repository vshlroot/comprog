package leetcode;

/**
 * Created by vishalss on 12/25/2015.
 */
public class LeetCode35 {
    public <T extends Comparable<T>> int binarySearch(T[] array, T element,int start, int end){
        if(start>=end){
            return start;
        }
        int mid=(start+end)/2;
        System.out.println("    Start= "+start+"End= "+end+"mid= "+mid);
        if(array[mid].compareTo(element)==0){
            return mid;
        }
        else if(array[mid].compareTo(element)<0){
            if(mid+1<array.length && array[mid+1].compareTo(element)>0){
                return -1*(mid+1);
            }
            return binarySearch(array,element,mid+1,end);
        }
        else{
            if(mid-1>=0 && array[mid-1].compareTo(element)<0){
                return -1*mid;
            }
            return binarySearch(array,element,start,mid-1);

        }
    }

    public int searchInsert(int[] nums, int target) {
        Integer[] input=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            input[i]=nums[i];
        }
        return Math.abs(binarySearch(input,target,0,input.length));
    }
}
