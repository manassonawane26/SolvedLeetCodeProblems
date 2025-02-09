class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> ans = new ArrayList<>();
        int totalSum = 0, currSum = 0;
        for(int num: nums){
            totalSum += num;
            pq.add(num);
        }
        while(!pq.isEmpty() && currSum <= totalSum){
            int n = pq.poll();
            totalSum-=n;
            currSum+=n;
            ans.add(n);
        }
        return ans;
    }
}