class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Find the frequency of each number
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        // Go through all numbers of the map and push them into
        // minHeap, which will have
        // the top k frequent numbers. If the heap size is more than k, we remove the
        // smallest (top) number.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) 
            res[i++] = minHeap.poll().getKey();

        return res;
    }
}