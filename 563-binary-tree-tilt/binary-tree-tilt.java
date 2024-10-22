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
    int sum;
    public int findTilt(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return sum;
    }
    int dfs(TreeNode root){
        if(root==null) return 0;

        int leftSum=dfs(root.left);
        int rightSum=dfs(root.right);
        sum+=Math.abs(leftSum-rightSum);
        return leftSum + rightSum + root.val;
    }
}