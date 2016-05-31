package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by vshlroot on 31/05/2016.
 */
/*
 Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to num2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */

/*
Approaches:
Brute Force
Hash
 */
public class LeetCode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null){
            return null;
        }

        ArrayList<Integer> resultArrayList=new ArrayList<>();
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(h.containsKey(nums1[i])){
                h.put(nums1[i],h.get(nums1[i])+1);
            }
            else {
                h.put(nums1[i], 1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(h.containsKey(nums2[i])){
                resultArrayList.add(nums2[i]);
                h.put(nums2[i],h.get(nums2[i])-1);
                if(h.get(nums2[i])<=0) {
                    h.remove(nums2[i]);
                }
            }
        }
        int[] result=new int[resultArrayList.size()];
        for (int i = 0; i < resultArrayList.size(); i++) {
            result[i]=(int)resultArrayList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a={1,2,2,3};
        int[] b={2,2,2,1,3,1};
        LeetCode350 ob=new LeetCode350();
        int result[]=ob.intersect(a,b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

}
