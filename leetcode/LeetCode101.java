package leetcode;

/**
 * Created by vishalss on 1/15/2016.
 */
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class LeetCode101 {

    // Trick is to move opposite in botht the trees.
    // If left in left subtree then go right int the right one and vice versa.
    
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if(left==null && right==null){
            return true;
        }
        else if (left==null || right==null || left.val!=right.val){
            return false;
        }
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}

