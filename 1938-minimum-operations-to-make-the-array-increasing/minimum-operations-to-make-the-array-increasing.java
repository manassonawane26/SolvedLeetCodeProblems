// class Solution {
//     public int minOperations(int[] nums) {
//         int n = nums.length;
//         int count=0;
//         if(n==1) return 0;
//         int i = n-1;
//         while(i>0){
//             if(nums[i-1]>=nums[i]){
//                 nums[i] = nums[i]+1;
//                 count++;
//                 //i = i+1;
//                 // System.out.println("i before "+i);
//                 // System.out.println(nums[i-1] + "  " + nums[i]);
//                 // System.out.println(i);
//             } else i-=1;
//         }
//         return count;
//     }
// }

class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        for(int i=0; i < nums.length-1; i++){
            if(nums[i+1] <= nums[i]){
                int temp = nums[i+1];
                nums[i+1] = nums[i]+1;
                count += nums[i+1] - temp;
            }
        }
        return count;
    }
}