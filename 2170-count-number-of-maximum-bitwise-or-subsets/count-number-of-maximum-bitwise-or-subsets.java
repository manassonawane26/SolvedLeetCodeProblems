class Solution {
    int n; // length of nums
    int max; // max of betwise-OR of nums
    int result = 0; // result
    public int countMaxOrSubsets(int[] nums) {
        n = nums.length;
        max = nums[0]; 
        for(int i = 1; i < nums.length; i++) //going through nums to find betwise-OR
            max = max | nums[i];
        backtrack(0,new ArrayList<>(),nums); // call magic function which go over all possible subsets of nums 
        return result;
    }
        public void backtrack(int first, ArrayList<Integer> curr, int [] nums){
        if(curr.size() > 0 && curr.get(curr.size() - 1) == max) // checking if current betwise-OR  equal the maximum 
            result++;
        for(int i = first; i < n; i++){
            if(curr.size() > 0) 
                curr.add(nums[i] | curr.get(curr.size() - 1)); 
            else
                curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
	//I would highly suggest debug this code to understand how this "remove" part works 
            curr.remove(curr.size() - 1); //important step we removing last element to maintain correct subset on the next iteration
        }
    }
}