// class Solution {
//     public boolean[] isArraySpecial(int[] nums, int[][] queries) {
//         //if(nums.length < 2) return new boolean[] {false};
//         boolean arr[] = new boolean[queries.length];
//         int k = 0;
        
//         for(int[] i: queries){
//             boolean flag = true;
//             for(int j = i[0]+1; j<=i[1]; j++){
//                 if((nums[j] % 2 == 0 && nums[j-1] % 2 == 0) || (nums[j] % 2 != 0 && nums[j-1] % 2 != 0)) {
//                     flag = false;
//                     break;
//                 }
//             }
//             arr[k++] = flag;

//         }
//         return arr;
//     }
// }

class Solution {
    // public boolean[] isArraySpecial(int[] nums, int[][] queries) {
    //     int n = nums.length;
    //     int[] prefix = new int[n]; // Prefix array to count special pairs
    //     boolean[] result = new boolean[queries.length]; // Result array
        
    //     // Step 1: Build the prefix array
    //     for (int i = 1; i < n; i++) {
    //         prefix[i] = prefix[i - 1];
    //         if ((nums[i - 1] % 2 == 0 && nums[i] % 2 == 0) || 
    //             (nums[i - 1] % 2 != 0 && nums[i] % 2 != 0)) {
    //             prefix[i]++;
    //         }
    //     }

    //     // Step 2: Process each query
    //     for (int i = 0; i < queries.length; i++) {
    //         int left = queries[i][0];
    //         int right = queries[i][1];
            
    //         // Calculate the number of special pairs in the range
    //         int specialCount = prefix[right] -  prefix[left];
            
    //         // If no special pairs, the result is true; otherwise, false
    //         result[i] = (specialCount == 0);
    //     }

    //     return result;
    // }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix = new int[nums.length];
        for(int i=1;i<nums.length;i++){
            if((nums[i]-nums[i-1])%2==0){
                prefix[i] = prefix[i-1]+1;
            } else {
                prefix[i] = prefix[i-1];
            }
        }
        boolean[] res = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
           int start = queries[i][0], end = queries[i][1];
           if(prefix[end]==prefix[start])
           res[i] = true;
        }
        return res;
    }

}