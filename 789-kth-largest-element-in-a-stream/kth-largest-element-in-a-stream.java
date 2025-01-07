class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            } 
            // else if (num > minHeap.peek()) {
            //     minHeap.offer(num);
            //     if (minHeap.size() > k) {
            //         minHeap.poll();
            //     }
            // }
        }
    }
    
    public int add(int val) {
         minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        } 
        // if (minHeap.size() < k) {
        //     minHeap.offer(val);
        // } else if (val > minHeap.peek()) {
        //     minHeap.offer(val);
        //     minHeap.poll();
        // }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */