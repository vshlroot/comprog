package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by vishalss on 1/16/2016.
 */
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

 */
public class LeetCode102 {

    // it's just BFS
    // so we will use a queue
    // One catch point is that for every level we need to return a separate list
    // hence we need to keep track of the no. of elements in the current leve.
    // for that levelCount is used, after every cycle it is updated to current size of queue.

    // Syntax wise:
        // LinkedList can be used both in the form of a queue and stack.
        // push pop will work as a stack
        // addFirat, removeLast will work as Queue.


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }

        ArrayList<Integer> temp;
        LinkedList<TreeNode> q1=new LinkedList<>();
        TreeNode tempNode;
        int i,levelCount=1;

        q1.push(root);
        while(!q1.isEmpty()){
            //System.out.println("levelCount= "+levelCount);
            temp=new ArrayList<>();
            for (i = 0; i < levelCount; i++) {
                tempNode=q1.getFirst();
                q1.removeFirst();
                //System.out.println(" size is"+q1.size());
                if(tempNode!=null) {
                    //System.out.println("Adding to array "+tempNode.val);
                    temp.add(tempNode.val);
                    q1.addLast(tempNode.left);
                    q1.addLast(tempNode.right);
                }
            }
            //System.out.println("temp size is "+temp.size());
            if(temp.size()>0)
                result.add(temp);
            levelCount=q1.size();
        }
        return result;
    }
}
