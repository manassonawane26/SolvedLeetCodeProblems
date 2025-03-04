// class Solution {
//     public List<Integer> lexicalOrder(int n) {
//         String[] arr = new String[n];
//         for(int i=1;i<=n;i++){
//             arr[i-1]= String.valueOf(i);
//         }
//         Arrays.sort(arr);
//         List<Integer> list= new ArrayList<>();
//         for(String s : arr){
//             list.add(Integer.parseInt(s));
//         }
//         return list;
//     }
// }

class Solution {
    private TrieNode root = new TrieNode();
    public List<Integer> lexicalOrder(int n) {
        for(int i = 1; i <= n; i++){
            TrieNode currNode = root;
            String key = String.valueOf(i);
            for(int j = 0; j < key.length(); j++){
                char c = key.charAt(j);
                if(currNode.children[c - '0'] == null){
                    currNode.children[c - '0'] = new TrieNode();
                }
                currNode = currNode.children[c - '0'];
            }

        }


        List<Integer> ans = new ArrayList<>();
        dfs(ans, root, new StringBuilder());
        return ans;
    }
    public void dfs(List<Integer> ans, TrieNode root, StringBuilder sb) {
        for (int i = 0; i < 10; i++) {
            if (root.children[i] != null) {
                sb.append(i);  
                ans.add(Integer.parseInt(sb.toString()));
                dfs(ans, root.children[i], sb);
                sb.deleteCharAt(sb.length() - 1); 
            }
        }
    }
}

class TrieNode {
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[10];
    }
}