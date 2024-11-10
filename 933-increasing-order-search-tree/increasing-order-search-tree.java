/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode temp;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy=new TreeNode(-1);
        temp = dummy;
        preorder(root);
        return dummy.right;
    }
    void preorder(TreeNode root){
        if(root==null) return;
        preorder(root.left);
        temp.right = new TreeNode(root.val);
        temp=temp.right;
        preorder(root.right);
    }
}