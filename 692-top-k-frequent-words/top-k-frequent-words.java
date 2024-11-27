class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> h = new HashMap<>();
    
        for(int i=0;i<words.length;i++){
            h.put(words[i],h.getOrDefault(words[i],0)+1);
        }
        
        PriorityQueue<String> pq = 
            new PriorityQueue<>((a, b) -> (h.get(b)-h.get(a))==0 ? a.compareTo(b) : h.get(b)-h.get(a));
        
        for(String s:h.keySet()){
            pq.add(s);            
        }
        
        List<String> ans = new ArrayList<>();
        while(k-->0){
            ans.add(pq.remove());
        }
        return ans;
    }
}