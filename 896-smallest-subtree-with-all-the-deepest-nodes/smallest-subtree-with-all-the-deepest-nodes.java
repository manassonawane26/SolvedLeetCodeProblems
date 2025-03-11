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
    // Function to find the subtree containing all the deepest nodes
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null; // Base case: If root is null, return null
        }
        
        // Calculate the heights of the left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // If left and right heights are equal, return the current root
        if (leftHeight == rightHeight) {
            return root;
        }
        
        // Otherwise, recurse into the deeper subtree
        if (leftHeight > rightHeight) {
            return subtreeWithAllDeepest(root.left); // Explore left subtree
        } else {
            return subtreeWithAllDeepest(root.right); // Explore right subtree
        }
    }

    // Helper function to calculate the height of a node
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0; // Base case: height of null node is 0
        }
        // Recursively calculate the height of the left and right subtrees
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}