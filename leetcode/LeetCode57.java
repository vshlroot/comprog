package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by vishalss on 1/27/2016.
 */
/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class LeetCode57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        // Base cases

        if(newInterval==null || newInterval==null){
            return intervals;
        }
        if(intervals.size()==0){
            intervals.add(newInterval);
            return intervals;
        }

        if(newInterval.end<intervals.get(0).start){
            intervals.add(0,newInterval);
            return intervals;
        }

        int i=0;
        Interval temp=null;

        /*
        Ignore ones that are strictly less than the new interval
        ignore the ones with...
              -----------
                        temp.end
                            --------------
                            newInterval.start
        */
        while(i<intervals.size()){
            temp=intervals.get(i);
            if(newInterval.start<= temp.end){
                break;
            }
            i++;
        }
        //System.out.println("i after FIrst phase = "+ i);

        // Now only explanation is that either the list is over or there is an overlap.

        // List is already over and hence newInterval wil be added at the last.
        if(i==intervals.size()){
            intervals.add(i,newInterval);
            return intervals;
        }

        // Lets check for an overlap now.
        Interval extraNode=new Interval();

        //System.out.println("temp.start= "+ temp.start);
        //System.out.println("temp.end= "+ temp.end);


        // New node can be inserted at ith position as it is strictly less than the next node.
        if(temp.start>newInterval.end){
            intervals.add(i,newInterval);
            return intervals;
        }

        // Overlap is there.
        // setting the start
        if(temp.start<newInterval.start){
            extraNode.start=temp.start;
        }
        else{
            extraNode.start=newInterval.start;
        }

        // newInterval.start will definitely be <= temp.end otherwise it would have been caught in upper conditions.

        // Means newInterval is encapsulated in some previous node in whole.
        // Hence returning the passed values as it is.

        if(temp.end>=newInterval.end){
            extraNode.end=temp.end;
            intervals.remove(i);
            intervals.add(i,extraNode);
            return intervals;
        }

        extraNode.end=newInterval.end;

        // Means we need to remove atleast current temp node.

        //System.out.println("1 i= "+i);
        intervals.remove(i);

        // Checking for further nodes.
        //System.out.println("2 Removed i= "+i);
        while(i<intervals.size()){
            temp=intervals.get(i);
            if(temp.end<extraNode.end) {
                intervals.remove(i);
                continue;
            }

            if(temp.start>extraNode.end){
                //System.out.println("In 3");
                extraNode.end=newInterval.end;
                intervals.add(i,extraNode);
                return intervals;
            }
            if(temp.start<=extraNode.end && extraNode.end<=temp.end) {
                extraNode.end = temp.end;
                intervals.remove(i);
                intervals.add(i, extraNode);
                return intervals;
            }
            i++;
        }
        //System.out.println("i at last is ="+i);
        //System.out.println("size of list at last is ="+intervals.size());
        if(i==intervals.size()){
            intervals.add(i,extraNode);
        }

        return intervals;
        // All elements are done now.
    }
}
