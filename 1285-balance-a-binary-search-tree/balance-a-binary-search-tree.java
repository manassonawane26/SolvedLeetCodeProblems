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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedEle = new ArrayList<>();
        inorder(root, sortedEle);
        return constructBalancedBST(sortedEle, 0, sortedEle.size()-1); 
    }

    private void inorder(TreeNode root, List sortedEle){
        if(root == null) return;

        inorder(root.left, sortedEle);
        sortedEle.add(root.val);
        inorder(root.right, sortedEle);
    }

    private TreeNode constructBalancedBST(List<Integer> sortedEle, int low, int high){
        if(low > high) return null;
        int mid = low + (high-low)/2;
        TreeNode node = new TreeNode(sortedEle.get(mid));
        node.left = constructBalancedBST(sortedEle, low , mid-1);
        node.right = constructBalancedBST(sortedEle, mid+1, high);
        return node;
    }
}