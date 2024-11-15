class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> list = new ArrayList<>();
        StringBuilder path = new StringBuilder();        
        
        binaryTreePathsHelper(root,path,list);
        return list;
        
    }
    
    public void binaryTreePathsHelper(TreeNode root,StringBuilder path,List<String> list){
        
        if(root == null) return ;
        
        int len = path.length();// inital length nikal li path ki taki path.setLength se backtracking kar sake
        path.append(root.val);
        
        if(root.left==null && root.right==null){            
            list.add(path.toString());
            path.setLength(len);// backtracking before return                                    
            return ;
        }
        
        path.append("->");
        
        binaryTreePathsHelper(root.left,path,list);
        binaryTreePathsHelper(root.right,path,list);
        
        path.setLength(len);// backtracking before return  
    }        
    
}