package leetcode;

/**
 * Created by vishalss on 1/16/2016.
 */
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class LeetCode110 {

    // Check the height of left tree and right tree.
    // if condition fails then return -1 else the +ve height.

    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!=-1;
    }

    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        if(leftHeight==-1)
            return -1;
        int rightHeight=getHeight(root.right);
        if(rightHeight==-1)
            return -1;
        if(Math.abs(leftHeight-rightHeight)>1)
            return -1;
        return Math.max(leftHeight,rightHeight)+1;
    }
}
