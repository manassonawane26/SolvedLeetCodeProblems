// class Solution {
//     private static class TrieNode {
//         TrieNode[] next;
//         int index;
//         List<Integer> list;
            
//         TrieNode() {
//             next = new TrieNode[26];
//             index = -1;
//             list = new ArrayList<>();
//         }
//     }
//     TrieNode root;
//     List<List<Integer>> res;

//     public List<List<Integer>> palindromePairs(String[] words) {
//         res = new ArrayList<>();
//         root = new TrieNode();
            
//         for (int i = 0; i < words.length; i++) {
//             addWord(words[i], i);
//         }
            
//         for (int i = 0; i < words.length; i++) {
//             search(words, i);
//         }
        
//         return res;
//     }
        
//     private void addWord(String word, int index) {
//         TrieNode node = root;
//         for (int i = word.length() - 1; i >= 0; i--) {
//             int j = word.charAt(i) - 'a';
                    
//             if (node.next[j] == null) {
//                 node.next[j] = new TrieNode();
//             }
                    
//             if (isPalindrome(word, 0, i)) {
//                 node.list.add(index);
//             }
                    
//             node = root.next[j];
//         }
            
//         node.list.add(index);
//         node.index = index;
//     }
        
//     private void search(String[] words, int i) {
//         TrieNode node = root;
//         for (int j = 0; j < words[i].length(); j++) {	
//             if (node.index >= 0 && node.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
//                 res.add(Arrays.asList(i, node.index));
//             }
                
//             node = node.next[words[i].charAt(j) - 'a'];
//             if (node == null) return; 
//         }
            
//         for (int j : node.list) {
//             if (i == j) continue;
//             res.add(Arrays.asList(i, j));
//         }
//     }
        
//     private boolean isPalindrome(String word, int i, int j) {
//         while (i < j) {
//             if (word.charAt(i++) != word.charAt(j--)) return false;
//         }
            
//         return true;
//     }
// }
// // store first string to the trie
// // check before inserting that reverse of that string is already there, if true add indexes
// // put curr string in Trie

// // how to return the index of String?


class Solution {
    private static class TrieNode {
    TrieNode[] next;
    int index;
    List<Integer> list;
    	
    TrieNode() {
    	next = new TrieNode[26];
    	index = -1;
    	list = new ArrayList<>();
    }
}
    
public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<>();

    TrieNode root = new TrieNode();
		
    for (int i = 0; i < words.length; i++) {
        addWord(root, words[i], i);
    }
		
    for (int i = 0; i < words.length; i++) {
        search(words, i, root, res);
    }
    
    return res;
}
    
private void addWord(TrieNode root, String word, int index) {
    for (int i = word.length() - 1; i >= 0; i--) {
        int j = word.charAt(i) - 'a';
				
        if (root.next[j] == null) {
            root.next[j] = new TrieNode();
        }
				
        if (isPalindrome(word, 0, i)) {
            root.list.add(index);
        }
				
        root = root.next[j];
    }
    	
    root.list.add(index);
    root.index = index;
}
    
private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
    for (int j = 0; j < words[i].length(); j++) {	
    	if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
    	    res.add(Arrays.asList(i, root.index));
    	}
    		
    	root = root.next[words[i].charAt(j) - 'a'];
      	if (root == null) return; 
    }
    	
    for (int j : root.list) {
    	if (i == j) continue;
    	res.add(Arrays.asList(i, j));
    }
}
    
private boolean isPalindrome(String word, int i, int j) {
    while (i < j) {
    	if (word.charAt(i++) != word.charAt(j--)) return false;
    }
    	
    return true;
}
}