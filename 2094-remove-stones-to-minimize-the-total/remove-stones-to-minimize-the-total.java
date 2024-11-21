class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(piles.length, Comparator.reverseOrder());
        for(int i: piles)
            pq.offer(i);
        
        for(int j =0;j<k; j++){
            int temp = pq.poll();
            temp = (int) temp - (int)Math.floor(temp/2);
            pq.offer(temp);
        }
        int sum=0;
        while(!pq.isEmpty())
            sum+=pq.poll();
        return sum;
    }
}