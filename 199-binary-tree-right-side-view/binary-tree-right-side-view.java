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
    List<Integer> list;
    int maxLevel;
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        maxLevel = -1;
        TreeNode temp = root;
        rightView(temp, 0);
        return list;
    }
    private void rightView(TreeNode root, int level){
        if(root == null) return;

        if(level > maxLevel) {
            list.add(root.val);
            maxLevel = level;   
        }
        // System.out.println(root.val + " leve =  "+ level + "Maxl "+ maxLevel);
        rightView(root.right, level+1);
        rightView(root.left, level+1);

    }
}