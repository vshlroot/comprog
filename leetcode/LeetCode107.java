package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by vishalss on 1/16/2016.
 */
/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

 */
public class LeetCode107 {

    // Either we can reverse the returned by the level order traversal
    // OR
    // we can just add the level traversal in the front rather than end.
    // either way works


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
                result.add(0,temp);
            levelCount=q1.size();
        }
        //Collections.reverse(result);
        return result;
    }
}
