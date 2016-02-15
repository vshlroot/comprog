package leetcode;

/**
 * Created by vishalss on 2/14/2016.
 */
/*
One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #

For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
 */
public class LeetCode331 {
    private String preorder;
    int validUpto;
    String[] str;
    public boolean isValidSerialization(String preorder) {
        //this.preorder=preorder;
        this.validUpto=0;
        str=preorder.split(",");
        boolean result=isValid(0);
        //System.out.println("result= "+result);
        //System.out.println("validUpto"+validUpto);
        if(validUpto<str.length-1)
            return false;
        else
            return result;

    }

    public boolean isValid(int root){
        //System.out.println("=======");
        //System.out.println("Chacking for= "+root);
        if(root>=str.length || validUpto>=str.length) {
            //System.out.println("validUpto is >length");
            return false;
        }
        //System.out.println("charAt= "+str[root]);
        if( str[root].equals("#")){
            //System.out.println("Found #");
            if(validUpto<=root){
                validUpto=root;
            }
            return true;
        }
        //System.out.println("validUpto right now is= "+validUpto);
        //System.out.println("=======");
        return isValid(root+1) && isValid(validUpto+1);
    }

    public static void main(String[] args) {
        String in="9,3,4,#,#,1,#,#,2,#,6,#,#,3";
        LeetCode331 ob=new LeetCode331();
        System.out.println(ob.isValidSerialization(in));
    }
}
