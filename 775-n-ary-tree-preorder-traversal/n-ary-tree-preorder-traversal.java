/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> output =  new ArrayList<>();
        helper(root, output);
        return output;
    }
    private void helper(Node root, List<Integer> output){
        if(root == null) return;
        output.add(root.val);
        for(int i=0;i < root.children.size();i++){
            helper(root.children.get(i), output);
        }
    }
}





