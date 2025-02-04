// class Solution {
//     public String replaceWords(List<String> dictionary, String sentence) {
        
//     }
// }

// class Solution {
//     class TrieNode {
//         TrieNode children[];
//         boolean isLast;
//         TrieNode(){
//             children = new TrieNode[27];
//             isLast = false;
//         }
//     }

//     TrieNode root;

//     private int getIndex(char c){
//         return c=='/' ? 26 : c-'a';
//     }
//     private void insert(String s){
//         TrieNode node = root;
//         for(char c: s.toCharArray()){
//             int index = getIndex(c);
//             if(node.children[index] == null){
//                 node.children[index] = new TrieNode();
//             }
//             node = node.children[index];
//         }
//         node.children[26] = new TrieNode();
//         node = node.children[26];
//         node.isLast = true;
//     }
//     private boolean search(String s){
//         TrieNode node = root;
//         for(char c: s.toCharArray()){
//             if(node.isLast) return true;;
//             int index = getIndex(c);
//             if(node.children[index]==null) return false;
//             node = node.children[index];
//         }
//         return node.isLast;
//     }
//     public List<String> removeSubfolders(String[] folder) {
//         root = new TrieNode();
//         Arrays.sort(folder, (a,b) -> a.length() - b.length());
//         List<String> ans = new ArrayList<>();
//         for(String f: folder){
//             if(!search(f)){
//                 insert(f);
//                 ans.add(f);
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;

    private void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int i = c - 'a';
            if(node.children[i] == null){
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }

    private String search(String word){
        TrieNode node = root;
        int j = 0;
        for(char c: word.toCharArray()){
            int i = c - 'a'; 
            j++;
            if(node.children[i] == null){
                return word;
            } else if (node.children[i].isEnd){
                return word.substring(0, j);
            } else {
                node = node.children[i];
            }
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        StringBuilder result =  new StringBuilder();
        String[] input = sentence.split(" ");
        for(String i:input){
            result.append(search(i));
            result.append(" ");
        }
        return result.toString().trim();
    }
}

// class Solution {
//     Trie root;
//     public String replaceWords(List<String> dictionary, String sentence) {
//         root = new Trie();
//         for(String word : dictionary){
//             insert(word);
//         }
//         StringBuilder result = new StringBuilder();
//         String []  input = sentence.split(" ");
//         for(String i : input){
//             result.append(search(i));
//             result.append(" ");
//         }
//         return result.toString().trim();
//     }
//     public String search(String word){
//         Trie node = root;
//         int j = 0;
//         for(char c : word.toCharArray()){
//             int i = c - 'a';
//             j++;
//             if(node.children[i] == null){
//                 return word;
//             }else if(node.children[i].isEnd){
//                 return word.substring(0, j);
//             }else{
//                 node = node.children[i];
//             }
            
//         }
//         return word;

//     }
//     public void insert(String word){
//         Trie node = root;
//         for(char c: word.toCharArray()){
//             int i = c - 'a';
//             if(node.children[i] == null){
//                 node.children[i] = new Trie();
//             }
//             node = node.children[i];
//         }
//         node.isEnd = true;
//     }
// }
// class Trie{
//     Trie [] children;
//     boolean isEnd;
//     public Trie(){
//         children = new Trie[26];
//         isEnd =false;
//     }
// } 