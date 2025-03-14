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
    int res = 0;
    public int maxSumBST(TreeNode root) {
        int[] r = recur(root);
        return res;
    }

    // return [isSubTreeBST, totalSumIfBST, minOfAllKeys, maxOfAllKeys]
    public int[] recur(TreeNode root) {
        if (root == null) return new int[] {1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] left = recur(root.left);
        int[] right = recur(root.right);
        if (left[0] != 1 || right[0] != 1) {
            // if any child is not a BST, then return
            return new int[] {0, 0, 0, 0};
        }
        
        // check child sub trees node values to confirm if subtree is BST or not
        if (left[3] < root.val && right[2] > root.val) {
            // subtree is a BST
            int min = Math.min(root.val, left[2]);
            int max = Math.max(root.val, right[3]);
            int sum = left[1] + right[1] + root.val;
            res = Math.max(res, sum);
            return new int[] {1, sum, min, max};
        }
        else return new int[] {0, 0, 0, 0};
    }
}