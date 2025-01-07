class Pair{
    long val;
    long idx;
    Pair(long a, long b){
        val = a;
        idx = b;
    }
}
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> (int) (a.val - b.val));
        // PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->((int)(a.val-b.val)));

        long n = nums.length;
        long min = Long.MAX_VALUE;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum>=k)
                min = Math.min(min, i+1);

            while(!pq.isEmpty() && sum - pq.peek().val >= k)
                min = Math.min(min, i - pq.poll().idx);
            
            pq.offer(new Pair(sum, i));
        }
        return min != Long.MAX_VALUE ? (int) min : -1;

    }
}
// class Solution {
//     public int shortestSubarray(int[] nums, int k) {
//         int count =0;
//         int sum=0;
//         for(int i:nums){
//             sum+=i;
//             count++;
//             if(sum >= k) return count;
//         }
//         return -1;
//     }
// }
// class Solution {
//     public int shortestSubarray(int[] nums, int k) {
        
//         int nLen = nums.length;
//         int shortest = nLen + 1;
        
// 		// Building a prefix/cummulative sum of all elements
//         long[] prefixSum = new long[nLen + 1];
//         for(int i=0; i < nLen; i++)
//             prefixSum[i+1] = prefixSum[i] + nums[i];
        
// 		// Initialize the Deque for storing the starting indices
//         Deque<Integer> startIdxs = new ArrayDeque<>();
        
//         for(int i=0; i < nLen + 1; i++){
//             // Finding the smallest window whose sum >= k
//             while(!startIdxs.isEmpty() && prefixSum[i] - prefixSum[startIdxs.peek()] >= k)
//                 shortest = Math.min(shortest, i - startIdxs.poll());
            
//             // Keeping the startIdxs deque in an order of increasing sequence
//             while(!startIdxs.isEmpty() && prefixSum[i] <= prefixSum[startIdxs.peekLast()])
//                 startIdxs.pollLast();
            
//             // Add the current index to the startIdxs queue
//             startIdxs.add(i);
//         }
        
//         return shortest <= nLen ? shortest : -1;
//     }
// }