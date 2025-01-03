class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());
        for(int i=0; i< nums.length; i++){
            pq.offer(new Pair<>(nums[i], i));
        }
        PriorityQueue<Pair<Integer, Integer>> pq2 = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(int i=0; i<k; i++)
            pq2.offer(pq.poll());

        int[] res = new int[k];
        int index = 0;
        while (!pq2.isEmpty())
            res[index++] = pq2.poll().getKey();

        return res;
    }
}