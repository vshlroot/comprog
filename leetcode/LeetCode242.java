package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by vishalss on 1/12/2016.
 */
/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int i=0;
        char ch;
        HashMap h=new HashMap();
        while (i<s.length()){
            ch=s.charAt(i);
            if(h.containsKey(ch)){
                h.put(ch,(int)h.get(ch)+1);
            }
            else {
                h.put(ch, 1);
            }
            i++;
        }
        i=0;
        while (i<t.length()){
            ch=t.charAt(i);
            if(!h.containsKey(ch)){
                return false;
            }
            h.put(ch,(int)h.get(ch)-1);
            i++;
        }
        Set keys=h.keySet();
        Iterator it=keys.iterator();
        while (it.hasNext()){
            if((int)h.get((char)it.next())!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="asda";
        String t="asaa";
        LeetCode242 ob=new LeetCode242();
        System.out.println(ob.isAnagram(s,t));
    }
}
