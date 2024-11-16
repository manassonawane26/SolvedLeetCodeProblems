// class Solution {
//     public int[] resultsArray(int[] nums, int k) {
//         if (k == 1) {
//             return nums.clone();
//         }
        
//         int n = nums.length;
//         List<Integer> result = new ArrayList<>();
//         Deque<Integer> window = new ArrayDeque<>();
        
//         for (int i = 0; i < n; i++) {
//             // Remove elements outside window
//             while (!window.isEmpty() && i - window.peekFirst() >= k) {
//                 window.pollFirst();
//             }
            
//             // Check consecutive sequence
//             if (window.isEmpty() || nums[i] - nums[i-1] == 1) {
//                 window.offerLast(i);
//             } else {
//                 window.clear();
//                 window.offerLast(i);
//             }
            
//             // Add result when window size is k
//             if (i >= k-1) {
//                 result.add(window.size() == k ? nums[i] : -1);
//             }
//         }
        
//         return result.stream().mapToInt(Integer::intValue).toArray();
//     }
// }


class Solution {
    public int[] resultsArray(int[] nums, int k) 
    {
        int n = nums.length;
        int subArrCount = n-k+1;
        int[] subArrPower = new int[n-k+1];
        int inconsecutiveElementCount = 0;
        for(int i=1; i<k; i++)
        {
            if(nums[i] != nums[i-1]+1)
            {
                inconsecutiveElementCount++;
            }
        }
        int start =0, end = k-1;
        while(end<n)
        {
            subArrPower[start] = inconsecutiveElementCount == 0 ? nums[end] : -1;
            if(start<n-1 && nums[start] != nums[start+1]-1)
            {
                inconsecutiveElementCount--;
            }
            start++;
            if(end<n-1 && nums[end+1] != nums[end]+1)
            {
                inconsecutiveElementCount++;
            }
            end++;
        }
        return subArrPower;
        
    }
}