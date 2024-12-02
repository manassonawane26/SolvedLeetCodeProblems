class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =  new PriorityQueue<>(Comparator.reverseOrder());
        for(int i: stones) pq.offer(i);

        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            if(a!=b) pq.offer(Math.abs(a-b));
        }

        if(pq.size() == 1)
            return pq.poll();
        return 0;
    }
}