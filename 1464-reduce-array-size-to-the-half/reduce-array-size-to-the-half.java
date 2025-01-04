class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<HashMap.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)-> b.getValue() - a.getValue());

        for(int i = 0; i < n; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: hm.entrySet())
            pq.offer(entry);

        int sum = 0, count = 0;
        while(sum<n/2){
            sum += pq.poll().getValue();
            count++;
        }
        return count;
    }
}