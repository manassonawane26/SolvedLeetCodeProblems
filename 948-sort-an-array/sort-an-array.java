class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> data = new PriorityQueue<>();

        for(int i : nums){
            data.add(i);
        }

        for(int i=0;i<nums.length;i++)
            nums[i]= data.poll();
        return nums;
    }
}