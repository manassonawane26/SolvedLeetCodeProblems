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
    private int deepest=0;
    private TreeNode node;
	public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root,0);
        return node;
    }
    private int helper(final TreeNode root, final int depth) {
        deepest = Math.max(deepest, depth);
        if(root == null)
            return depth;

        int left = helper(root.left, depth+1);
        int right = helper(root.right, depth+1);

        if(left == deepest && left == right)
            node=root;
        return Math.max(left, right);
    }
}

// class Solution {
// 	public TreeNode lcaDeepestLeaves(TreeNode root) {
// 		if(root == null){
// 			return null;
// 		}

// 		int left = height(root.left);
// 		int right = height(root.right);
// 		if(left == right){
// 			return root;
// 		}else if(left > right){
// 			return lcaDeepestLeaves(root.left);
// 		}else{
// 			return lcaDeepestLeaves(root.right);
// 		}
// 	}

// 	private int height(TreeNode root){
// 		if(root == null){
// 			return 0;
// 		}
// 		return 1 + Math.max(height(root.left), height(root.right));
// 	}
// }