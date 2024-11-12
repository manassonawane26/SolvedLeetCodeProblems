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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> ans = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        while(q1.size()>0){
            int n = q1.size();
            double sum = 0.000;
            for(int i=0; i<n;i++){
                TreeNode node = q1.poll();
                sum = sum + node.val;
                if(node.left!=null) q1.offer(node.left);
                if(node.right!=null) q1.offer(node.right);
            }
            ans.add(sum/n);
        }
        return ans;
    }
}