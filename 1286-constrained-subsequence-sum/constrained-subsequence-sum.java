class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        Queue<Integer> queue=new PriorityQueue<>((a,b)->dp[b]-dp[a]); //Declaring Max heap
        int res=nums[0];
        dp[0]=nums[0];
        queue.offer(0);
        
        for(int j=1;j<n;j++){
            while(!queue.isEmpty() && queue.peek() < j-k) queue.poll();
            dp[j]=Math.max(dp[queue.peek()]+nums[j],nums[j]);
            res=Math.max(res,dp[j]);
            queue.offer(j);
        }
        return res;
    }
}