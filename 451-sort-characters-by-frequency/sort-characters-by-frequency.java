

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray())
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));
        pq.addAll(hm.keySet());
        
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for(int i=0; i<hm.get(c);i++) result.append(c);
        }
        
        return result.toString();
    }
}

