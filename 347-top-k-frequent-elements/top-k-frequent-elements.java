// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // Find the frequency of each number
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int n: nums){
//             map.put(n, map.getOrDefault(n,0)+1);
//         }

//         PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
//                 (a, b) -> a.getValue() - b.getValue());

//         // Go through all numbers of the map and push them into
//         // minHeap, which will have
//         // the top k frequent numbers. If the heap size is more than k, we remove the
//         // smallest (top) number.
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             minHeap.add(entry);
//             if (minHeap.size() > k) {
//                 minHeap.poll();
//             }
//         }

//         int[] res = new int[k];
//         int i = 0;
//         while (!minHeap.isEmpty()) 
//             res[i++] = minHeap.poll().getKey();

//         return res;
//     }
// }

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        
        for (int i : nums)
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));
        pq.addAll(hm.keySet());
        
        int arr[] = new int[k];
        for(int i=0;i<k;i++){
            arr[i]=pq.poll();
        }
        // StringBuilder result = new StringBuilder();
        // while (!pq.isEmpty()) {
        //     char c = pq.poll();
        //     for(int i=0; i<hm.get(c);i++) result.append(c);
        // }
        
        return arr;
    }
}