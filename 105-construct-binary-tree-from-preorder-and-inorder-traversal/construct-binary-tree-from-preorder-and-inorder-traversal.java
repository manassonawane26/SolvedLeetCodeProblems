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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderIdxMap =  new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++) inOrderIdxMap.put(inorder[i], i);
        return splitTree(preorder, inOrderIdxMap, 0, 0, n-1);
    }
    private TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderIdxMap, int rootIdx, int left, int right){
        TreeNode root = new TreeNode(preorder[rootIdx]);
        int mid = inOrderIdxMap.get(preorder[rootIdx]);
        if(mid>left) 
            root.left = splitTree(preorder, inOrderIdxMap, rootIdx+1, left, mid-1);
        if(mid<right)
            root.right = splitTree(preorder, inOrderIdxMap, rootIdx+mid-left+1, mid+1, right );
        return root;
    }
}