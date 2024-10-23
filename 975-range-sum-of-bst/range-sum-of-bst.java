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
    int sum, low, high;

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low=low;
        this.high=high;
        dfs(root);
        return sum;
    }
    void dfs(TreeNode root){
        if(root==null) return;
        if(root.val>=low && root.val <= high){
            sum+=root.val;
            System.out.println("val= "+root.val);
        }
            
        dfs(root.left);
        dfs(root.right);
        
        // if(val )
        
        
        // return sum+=;
    }
}