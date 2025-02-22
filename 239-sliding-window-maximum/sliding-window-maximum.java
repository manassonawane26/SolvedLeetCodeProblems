class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> nums[b] - nums[a]);
        int n = nums.length;
        int [] ans = new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            while(pq.size()>0 && pq.peek()<=i-k){
                pq.remove();
            }
            pq.add(i);
            if(i>=k-1){
                ans[idx++]=nums[pq.peek()];
            }
        }
        return ans;
    }
}