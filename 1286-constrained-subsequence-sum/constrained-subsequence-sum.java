class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.add(new int[]{0, -1});
        int res=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; ++i) {
            while(!pq.isEmpty() && pq.peek()[1]<i-k)
                pq.poll();
            // int v[]=pq.peek();
            int temp=pq.peek()[0]+nums[i];
            pq.add(new int[]{Math.max(0, temp), i});
            res=Math.max(res, temp);
        }
        return res;
    }
}

// class Solution {
//     public int constrainedSubsetSum(int[] nums, int k) {
//         int res = Integer.MIN_VALUE;
//         Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
//         for (int i = 0; i < nums.length; i++) {
//             while (!maxHeap.isEmpty() && (i - maxHeap.peek()[0] > k)) {
//                 maxHeap.poll();
//             }
//             int temp = 0;
//             if (!maxHeap.isEmpty()) 
//                 temp = maxHeap.peek()[1];
//             temp += nums[i];
//             temp = Math.max(temp, nums[i]);
//             res = Math.max(res, temp);
//             maxHeap.add(new int[]{i, temp});
//         }
//         return res;
//     }
// }


/*
    dp(i) = max(arr[i], max(dp(i-1), dp(i-2), ... dp(i-k)) + arr[i])
*/

// class Solution {
//     public int constrainedSubsetSum(int[] nums, int k) {
//         int n=nums.length;
//         int[] dp=new int[n];
//         Arrays.fill(dp,Integer.MIN_VALUE);
//         Queue<Integer> queue=new PriorityQueue<>((a,b)->dp[b]-dp[a]); //Declaring Max heap
//         int res=nums[0];
//         dp[0]=nums[0];
//         queue.offer(0);
        
//         for(int j=1;j<n;j++){
//             while(!queue.isEmpty() && queue.peek() < j-k) queue.poll();
//             dp[j]=Math.max(dp[queue.peek()]+nums[j],nums[j]);
//             res=Math.max(res,dp[j]);
//             queue.offer(j);
//         }
//         return res;
//     }
// }