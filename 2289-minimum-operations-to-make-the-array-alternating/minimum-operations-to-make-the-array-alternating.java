// class Solution {
//     public int minimumOperations(int[] nums) {
//         if (nums.length <= 1) return 0;
		
// 		// First map the numbers to frequencies
//         Map<Integer, Integer> evenFreq = new HashMap<>();
//         Map<Integer, Integer> oddFreq = new HashMap<>();
        
// 		// Also generate counts for evens and odds, this can be improved with simple math
//         int evenCount = 0;
//         int oddCount = 0;
//         for (int i = 0; i < nums.length; ++i) {
//             Map<Integer, Integer> currMap;
//             if ((i % 2) == 0) {
//                 currMap = evenFreq;
//                 evenCount++;
//             }
//             else {
//                 currMap = oddFreq;
//                 oddCount++;
//             }
//             currMap.put(nums[i], currMap.getOrDefault(nums[i], 0)+1);
//         }
        
// 		// Put the character:frequency mappings into a priority queue by frequency
//         PriorityQueue<Pair<Integer, Integer>> evenQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
//         for (int key : evenFreq.keySet()) {
//             evenQueue.add(new Pair<Integer, Integer>(key, evenFreq.get(key)));
//         }
        
//         PriorityQueue<Pair<Integer, Integer>> oddQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
//         for (int key : oddFreq.keySet()) {
//             oddQueue.add(new Pair<Integer, Integer>(key, oddFreq.get(key)));
//         }
        
// 			// You want to keep the largest value the same so if evenFreq.peek() (can now consider it larger freq)
// 			// is smaller than the oddFreq (now smallerFreq), switch them
// 			// Importantly, you also have to switch them if they are the same!
// 			// That tripped me up for a while 
//         if (evenQueue.peek().getValue() <= oddQueue.peek().getValue()) {
//             int tmp = oddCount;
//             oddCount = evenCount;
//             evenCount = tmp;
            
//             PriorityQueue<Pair<Integer, Integer>> mapTmp = evenQueue;
//             evenQueue = oddQueue;
//             oddQueue = mapTmp;
//         }
        
		
// 		// Now the number of things to change on the even indices is this
//         int evenDiff = evenCount - evenQueue.peek().getValue();
        
// 		// If the top number in the odd queue is the same as your even number that you are keeping
// 		// the same you must use the second highest number, or change them all if there is no 
// 		// second highest number. 
//         if (evenQueue.peek().getKey() == oddQueue.peek().getKey()) {
//             oddQueue.poll();
//         }
//         int oddDiff;
//         if (oddQueue.size() == 0) {
//             oddDiff = oddCount;
//         }
//         else {
//             oddDiff = oddCount - oddQueue.peek().getValue();
//         }
		
// 		// Return value is just the sum of the changes made to the even and odd parts of the array
//         return oddDiff + evenDiff;
//     }
// }
class Solution {
    public int minimumOperations(int[] nums) {
	    // Find even and odd position frequency.
        int[] count1=new int[100001];
        int[] count2=new int[100001];
		
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i%2==0) count1[nums[i]]++;
            else count2[nums[i]]++;
        }
		
		//find max and second max along with it freq.
		//even[0]=max , even[1]=freq of max
		//even[2]=secondMax, even[3]=freq of secondMax
		//same of odd pos.
        int[] even=new int[4];
        int[] odd=new int[4];
        for(int i=0;i<100001;i++){
            int c=count1[i];
            if(even[0]<c){   //if greater than first max
			    // first keep last max to second max then update new max
                even[2]=even[0];
                even[3]=even[1];
                even[0]=c;
                even[1]=i;
            }else if(even[2]<c){  //if value is less than max and greater than second max
			    //we don't need to save any value, just update second max.
                even[2]=c;
                even[3]=i;
            }
            
			//same procedure will be followed for odd pos.
			
            c=count2[i];
            if(odd[0]<c){
                odd[2]=odd[0];
                odd[3]=odd[1];
                odd[0]=c;
                odd[1]=i;
            }else if(odd[2]<c){
                odd[2]=c;
                odd[3]=i;
            }
        }
        
        //if count of both alternating pos is equal then we will consider one second max val
		//second max val can be of either even arr or odd arr(any of these) 
		//so we will take minimum of any case.
		if(odd[1]==even[1])
            return Math.min(n-even[2]-odd[0], n-odd[2]-even[0]);
        else return n-even[0]-odd[0];
    }
}