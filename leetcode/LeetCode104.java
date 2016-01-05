package leetcode;

/**
 * Created by vishalss on 1/5/2016.
 */
/*

Total Accepted: 111357 Total Submissions: 238324 Difficulty: Easy

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class LeetCode104 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return Integer.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
}
