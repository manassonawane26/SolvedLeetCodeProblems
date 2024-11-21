class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(piles.length, Comparator.reverseOrder());
        int sum=0;
        for(int i: piles){
            pq.offer(i);
            sum+=i;
        }
        
        for(int j =0;j<k; j++){
            int temp = pq.poll();
            sum = sum - temp/2;
            temp = temp - temp/2;
            pq.offer(temp);
        }
        
        // while(!pq.isEmpty())
        //     sum+=pq.poll();
        return sum;
    }
}