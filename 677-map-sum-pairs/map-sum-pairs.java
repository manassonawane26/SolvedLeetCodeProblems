// class TrieNode {
//     TrieNode[] children;
//     int sum;
//     TrieNode(){
//         children = new TrieNode[26];
//         sum = 0;
//     }
// }
// class MapSum {
//     TrieNode root;
//     public MapSum() {
//         root = new TrieNode();
//     }
    
//     public void insert(String key, int val) {
//         TrieNode node = root;
//         for(char c: key.toCharArray()){
//             int i = c-'a';
//             if(node.children[i] == null){
//                 node.children[i] = new TrieNode();
//             }
//             // node.sum = val;
//             node = node.children[i];
//         }
//         node.sum = val;
//     }
    
//     public int sum(String prefix) {
//         TrieNode node = root;
//         for(char c: prefix.toCharArray()){
//             int i = c-'a';
//             if(node.children[i] == null){
//                 return 0;
//             }
//             node = node.children[i];
//         }
//         return node.sum;
//     }
// }

// /**
//  * Your MapSum object will be instantiated and called as such:
//  * MapSum obj = new MapSum();
//  * obj.insert(key,val);
//  * int param_2 = obj.sum(prefix);
//  */

class MapSum {
    
    TrieNode trie;
    int sum = 0;
    public MapSum() {
        trie = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode node = trie;
        for(char ch : key.toCharArray()){
            
            if(node.childs[ch - 'a'] == null){
                node.childs[ch - 'a'] = new TrieNode();
            }
            
            node = node.childs[ch - 'a'];
            
        }
        
        node.isEnd = true;
        node.val = val;
    }
    
    public int sum(String prefix) {
        sum = 0;
        boolean isWordAvailableWithPrefix = true;
        TrieNode node = trie;
        for(char ch : prefix.toCharArray()){
             if(node.childs[ch - 'a'] == null){
                isWordAvailableWithPrefix = false;
                 break;
            }
            
            node = node.childs[ch - 'a'];
        }
        
        if(isWordAvailableWithPrefix){
            
            sum += node.val;
            getSum(node);
           
        }
        
        return sum;
        
    }
    
    public void getSum(TrieNode node){
        if(node == null){
            return;
        }
        for(int i = 0 ; i < 26 ; i++){
            TrieNode child = node.childs[i];
            if(child!=null && child.isEnd){
                sum+=child.val;
                //System.out.println(sum);
            }
            getSum(child);
        }
        
    }
}

class TrieNode{
    TrieNode[] childs;
    boolean isEnd = false;
    int val = 0;
    
    public TrieNode(){
        childs = new TrieNode[26];
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */