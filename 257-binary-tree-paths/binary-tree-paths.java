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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root != null) searchBT(root, "", paths);
        return paths;
    }

    private void searchBT(TreeNode root, String path, List<String> paths){
        if(root.left == null && root.right == null) paths.add(path + root.val);
        if(root.left !=null) searchBT(root.left, path+root.val + "->", paths);
        if(root.right !=null) searchBT(root.right, path+root.val + "->", paths);
    }
}