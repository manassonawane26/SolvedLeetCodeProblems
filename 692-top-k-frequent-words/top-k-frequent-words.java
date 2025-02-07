// class Solution {
//     public List<String> topKFrequent(String[] words, int k) {
//         HashMap<String,Integer> h = new HashMap<>();
    
//         for(int i=0;i<words.length;i++){
//             h.put(words[i],h.getOrDefault(words[i],0)+1);
//         }
        
//         PriorityQueue<String> pq = 
//             new PriorityQueue<>((a, b) -> (h.get(b)-h.get(a))==0 ? a.compareTo(b) : h.get(b)-h.get(a));
        
//         for(String s:h.keySet()){
//             pq.add(s);            
//         }
        
//         List<String> ans = new ArrayList<>();
//         while(k-->0){
//             ans.add(pq.remove());
//         }
//         return ans;
//     }
// }

class CountStringPair {
    int count;
    String str;

    public CountStringPair(int count, String str) {
        this.count = count;
        this.str = str;
    }

    public int getCount() {
        return count;
    }

    public String getStr() {
        return str;
    }
}

class Trie {
    Trie[] links;
    int count;

    public Trie() {
        links = new Trie[26];
        count = 0;
    }
}

class Solution {
    Trie root = new Trie();

    public List<String> topKFrequent(String[] words, int k) {
        // Insert words into the Trie
        for (String word : words) {
            Trie node = root;
            for (char ch : word.toCharArray()) {
                if (node.links[ch - 'a'] == null) {
                    node.links[ch - 'a'] = new Trie();
                }
                node = node.links[ch - 'a'];
            }
            node.count++;
        }

        // Use a priority queue to maintain the top k frequent words
        PriorityQueue<CountStringPair> pq = new PriorityQueue<>((a, b) -> {
            if (a.getCount() == b.getCount()) {
                return b.getStr().compareTo(a.getStr()); // Reverse lexicographical order for ties
            }
            return Integer.compare(a.getCount(), b.getCount()); // Min-heap based on count
        });

        // Collect all words and their counts using Trie traversal
        collectWords(root, new StringBuilder(), pq, k);

        // Create a list to store the result
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getStr());
        }

        // Reverse the result list to have the most frequent words first
        Collections.reverse(result);
        return result;
    }

    private void collectWords(Trie node, StringBuilder prefix, PriorityQueue<CountStringPair> pq, int k) {
        if (node == null) {
            return;
        }

        // If the node is a word end, add it to the priority queue
        if (node.count > 0) {
            pq.offer(new CountStringPair(node.count, prefix.toString()));
            if (pq.size() > k) {
                pq.poll(); // Remove the least frequent word
            }
        }

        // Traverse all possible links (children nodes)
        for (int i = 0; i < 26; i++) {
            if (node.links[i] != null) {
                char nextChar = (char) (i + 'a');
                prefix.append(nextChar);
                collectWords(node.links[i], prefix, pq, k);
                prefix.deleteCharAt(prefix.length() - 1); // Backtrack
            }
        }
    }
}