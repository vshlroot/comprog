package leetcode;

/**
 * Created by vishalss on 1/9/2016.
 */
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp=new int[nums1.length];
        int i;
        for(i=0;i<m;i++){
            temp[i]=nums1[i];
        }
        i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(temp[i]<=nums2[j]){
                nums1[k]=temp[i];
                i++;
            }
            else {
                nums1[k]=nums2[j];
                j++;
            }
            k++;
        }
        // copy j
        if(i>=m){
            while (j<n){
                nums1[k]=nums2[j];
                j++;
                k++;
            }
        }
        //copy
        else if(j>=n){
            while (i<m){
                nums1[k]=temp[i];
                i++;
                k++;
            }
        }
        System.out.println(k);
    }
}
