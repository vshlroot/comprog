package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vishalss on 1/23/2016.
 */

/*
Implements the LRU Cache using collections.
Uses LinkedHashSet.

It is noticed that the custom implementation is slower than this one.
Verified this on OJ.

// Implements LRU Cache int. Can be generalized later on.
 */
public class LRUCacheLinkedHashMap extends LinkedHashMap<Integer,Integer>{
    private int capacity;

    public LRUCacheLinkedHashMap(int capacity){
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }


    public void set(int key, int value){
        super.put(key,value);
    }

    public int get(int key){
        Integer value=super.get(key);
        return value==null?-1:value;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size()>capacity;
    }

    public static void main(String[] args) {
        LRUCacheLinkedHashMap ob=new LRUCacheLinkedHashMap(2);
        ob.set(2,13);
        ob.set(1,14);
        System.out.println(ob.get(2));
        System.out.println(ob.get(1));
        ob.set(4,15);
        ob.set(4,15);
        System.out.println(ob.get(1));
        System.out.println(ob.get(2));
        System.out.println(ob.get(4));
    }
}
