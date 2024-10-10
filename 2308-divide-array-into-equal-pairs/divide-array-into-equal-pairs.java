// class Solution {
//     public boolean divideArray(int[] nums) {
//         Arrays.sort(nums);
//         for(int i=0; i<nums.length; i=i+2)
//             if((nums[i] ^ nums[i+1]) != 0)
//                 return false;
        
//         return true;
//     }
// }
class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int x : nums)
            maps.put(x, maps.getOrDefault(x, 0) + 1);
        for (Map.Entry<Integer, Integer> s : maps.entrySet()) {
            if (s.getValue() % 2 != 0)
                return false;
        }
        return true;
    }
}