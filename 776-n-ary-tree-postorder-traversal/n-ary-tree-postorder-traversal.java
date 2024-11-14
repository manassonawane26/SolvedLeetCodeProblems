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
}
*/


class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> output =  new ArrayList<>();
        helper(root, output);
        return output;
    }
    private void helper(Node root, List<Integer> output){
        if(root == null) return;
        for(int i=0;i < root.children.size();i++){
            helper(root.children.get(i), output);
        }
        output.add(root.val);
    }
}

















// class Solution {
//     public void helper(Node root, List<Integer> res) {
//         if (root == null) return;
//         for (Node child : root.children) {
//             helper(child, res);
//         }
//         res.add(root.val);
//     }

//     public List<Integer> postorder(Node root) {
//         List<Integer> res = new ArrayList<>();
//         helper(root, res);
//         return res;
//     }
// }